package co.uniquindio.edu.co.servicios.implementacion;

import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.paciente.*;
import co.uniquindio.edu.co.modelo.entidades.*;
import co.uniquindio.edu.co.modelo.enums.*;
import co.uniquindio.edu.co.repositorio.*;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PacienteServicioImpl implements PacienteServicio {

    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;
    private final CitaRepo citaRepo;
    private final HorarioRepo horarioRepo;
    private final PacienteRepo pacienteRepo;
    private final AtencionRepo atencionRepo;
    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {
        if( estaRepetidaCedula(registroPacienteDTO.cedula()) ){
            throw new Exception("La cédula "+registroPacienteDTO.cedula()+" ya está en uso");
        }

        if( estaRepetidoCorreo(registroPacienteDTO.correo()) ){
            throw new Exception("El correo "+registroPacienteDTO.cedula()+" ya está en uso");
        }

        Paciente paciente = new Paciente();
        paciente.setCedula(registroPacienteDTO.cedula() );
        paciente.setTelefono(Integer.parseInt(registroPacienteDTO.telefono()));
        paciente.setNombre(registroPacienteDTO.nombre() );
        paciente.setAlergias( registroPacienteDTO.alergias() );
        paciente.setCiudad(registroPacienteDTO.ciudad());
        paciente.setCorreo(registroPacienteDTO.correo() );

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(registroPacienteDTO.password());

        paciente.setPassword(passwordEncriptada);
        paciente.setUrl_foto(registroPacienteDTO.urlFoto());
        paciente.setEstado(EstadoUsuario.ACTIVO);
        paciente.setTipo_Sangre(registroPacienteDTO.tipoSangre());
        paciente.setEps(registroPacienteDTO.eps());

        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();

    }

    @Override
    public int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception {
        Optional<Paciente> opcional =pacienteRepo.findById(detallePacienteDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+detallePacienteDTO.codigo());
        }

        Paciente buscado = opcional.get();

        buscado.setCedula(detallePacienteDTO.cedula() );
        buscado.setTelefono(Integer.parseInt(detallePacienteDTO.telefono()));
        buscado.setNombre(detallePacienteDTO.nombre() );
        buscado.setAlergias( detallePacienteDTO.alergias() );
        buscado.setCiudad(detallePacienteDTO.ciudad());
        buscado.setCorreo(detallePacienteDTO.correo() );
        buscado.setUrl_foto(detallePacienteDTO.urlFoto());
        buscado.setFecha_Nacimiento(detallePacienteDTO.fechaNacimiento());
        buscado.setTipo_Sangre(detallePacienteDTO.tipoSangre());
        buscado.setEps(detallePacienteDTO.eps());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(detallePacienteDTO.password());

        buscado.setPassword(passwordEncriptada);

        pacienteRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {
        Optional<Paciente> opcional =pacienteRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigo);
        }

        Paciente buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        pacienteRepo.save( buscado );
    }

    @Override
    public void enviarLinkRecuperacion() {

    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {
    Optional<Paciente> opcional = Optional.ofNullable(pacienteRepo.findByCorreo(nuevaPasswordDTO.correo()));
    if(opcional.isEmpty()){
        throw new Exception("No existe una cuenta con el correo: " +nuevaPasswordDTO.correo());
    }
    Paciente buscado = opcional.get();

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String passwordEncriptada = passwordEncoder.encode(nuevaPasswordDTO.nuevaPassword());

    buscado.setPassword(passwordEncriptada);
    pacienteRepo.save(buscado);

    }

    @Override
    public void agendarCitas(AgendarCitaDTO agendarCitaDTO) throws Exception {
        List<ItemCitaPacienteDTO> listaCitasPacientes = listarCitasPaciente(agendarCitaDTO.codigoPaciente());
        Optional<Paciente>  paciente = pacienteRepo.findById(agendarCitaDTO.codigoPaciente());
        int contador = 0;
        for(ItemCitaPacienteDTO cita : listaCitasPacientes){
            if(cita.estadoCita().equals(EstadoCita.PROGRAMADA)){
                contador++;
                if(contador>3){
                    throw new Exception("Solo puede tener 3 citas programadas al mismo tiempo");
                }else{
                    Cita citaNueva = new Cita();
                    citaNueva.setFechaCreacion(LocalDateTime.now());
                    citaNueva.setFechaCita(agendarCitaDTO.fechaCita());
                    citaNueva.setMotivo(agendarCitaDTO.motivo());
                    citaNueva.setPaciente(paciente.get());
                    citaNueva.setMedico(agendarCitaDTO.medico());
                    citaNueva.setEstado(EstadoCita.PROGRAMADA);
                    citaRepo.save(citaNueva);
                }
            }
        }
    }

    @Override
    public List<InfoMedicoPacienteDTO> listarMedicosEspecialidad(String especialidad) throws Exception {
        List<HorarioMedico> listaHorarioMedico = horarioRepo.findAll();
        List<Medico> listaMedicos = medicoRepo.findAll();
        List<InfoMedicoPacienteDTO> listaMedicoEspecialidad = new ArrayList<>();
        List<HorarioDTO> listaHorarioDTO = new ArrayList<>();

        for (Medico medico: listaMedicos) {
            Especialidad especialidadEnum = Especialidad.valueOf(especialidad);
            if(medico.getEspecialidad().equals(especialidadEnum)){
                int codigomedico = medico.getCodigo();
                for (HorarioMedico horarioMedico: listaHorarioMedico) {
                    if(horarioMedico.getMedico().getCodigo()==codigomedico){
                        listaHorarioDTO.add(new HorarioDTO(horarioMedico.getDia(),
                                                            horarioMedico.getHoraInicio(),
                                                            horarioMedico.getHoraFin()));
                        listaMedicoEspecialidad.add(new InfoMedicoPacienteDTO(medico.getNombre(),
                                                    medico.getEspecialidad(),
                                                    listaHorarioDTO));
                    }
                }
            }else{
                throw new Exception("No hay médicos con la especialidad:" + especialidad);
            }
        }


return listaMedicoEspecialidad;
    }

    @Override
    public void crearPQRS(CrearPQRSDTO crearPQRSDTO) throws Exception {
        int contador = 0;
        Optional<Cita> opcional = citaRepo.findById(Integer.valueOf(crearPQRSDTO.codigoCita()));
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        for (Pqrs pqrsActivas : listaPqrs) {
            if (pqrsActivas.getEstado().equals(EstadoPQRS.EN_PROCESO)) {
                if (pqrsActivas.getCita().getPaciente().getCodigo() == opcional.get().getPaciente().getCodigo()) {
                    contador++;
                }
                if (contador < 3) {
                    Pqrs pqrs = new Pqrs();
                    pqrs.setEstado(EstadoPQRS.NUEVO);
                    pqrs.setTipo(TipoPQRS.valueOf(crearPQRSDTO.tipo()));
                    pqrs.setCita(opcional.get());
                    pqrs.setMotivo(crearPQRSDTO.motivo());
                    pqrs.setFechaCreacion(LocalDateTime.now());
                    pqrsRepo.save(pqrs);
                } else {
                    throw new Exception("Solo puede tener 3 PQRS activas");
                }
            }

        }
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS(int codigoPaciente) throws Exception {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();
        for (Pqrs pqrsDelPaciente:listaPqrs) {
            if(pqrsDelPaciente.getCita().getPaciente().getCodigo()==codigoPaciente){
                respuesta.add(new ItemPQRSDTO(pqrsDelPaciente.getCodigo(),
                                pqrsDelPaciente.getEstado(), pqrsDelPaciente.getMotivo(), pqrsDelPaciente.getFechaCreacion(),
                        pqrsDelPaciente.getCita().getPaciente().getNombre()));
                }
            }
        return respuesta;
        }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        Optional<Pqrs> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuestaDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha( LocalDateTime.now() );
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setContenido(registroRespuestaDTO.mensaje() );

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public List<ItemCitaPacienteDTO> listarCitasPaciente(int codigoPaciente) {
        List<Cita> listaCitas = citaRepo.findAll();
        List<ItemCitaPacienteDTO> respuesta = new ArrayList<>();

        for (Cita cita:listaCitas) {
            if(cita.getPaciente().getCodigo()==codigoPaciente){
                respuesta.add(new ItemCitaPacienteDTO(cita.getFechaCreacion(),
                        cita.getFechaCita(), cita.getMotivo(), new MedicoCitasPacienteDTO(cita.getMedico().getNombre(),
                                                            cita.getMedico().getEspecialidad()), cita.getEstado()));
            }
        }
        return respuesta;
    }

    @Override
    public List<ItemCitaPacienteDTO> filtrarCitasPorFecha(LocalDateTime fecha) {
        List<Cita> listaCitas = citaRepo.findAll();
        List<ItemCitaPacienteDTO> respuesta = new ArrayList<>();

        for (Cita cita:listaCitas) {
            if(cita.getFechaCita().equals(fecha)){
                respuesta.add(new ItemCitaPacienteDTO(cita.getFechaCreacion(),
                        cita.getFechaCita(), cita.getMotivo(), new MedicoCitasPacienteDTO(cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad()), cita.getEstado()));
            }
        }
        return respuesta;
    }

    @Override
    public List<ItemCitaPacienteDTO> filtrarCitasPorMedico(int codigoMedico) {
        List<Cita> listaCitas = citaRepo.findAll();
        List<ItemCitaPacienteDTO> respuesta = new ArrayList<>();

        for (Cita cita:listaCitas) {
            if(cita.getMedico().getCodigo()==codigoMedico){
                respuesta.add(new ItemCitaPacienteDTO(cita.getFechaCreacion(),
                        cita.getFechaCita(), cita.getMotivo(), new MedicoCitasPacienteDTO(cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad()), cita.getEstado()));
            }
        }
        return respuesta;
    }

    @Override
    public AtencionMedicoDTO verDetalleCita(int codigoCita) throws Exception {
        List<Atencion> listaAtenciones = atencionRepo.findAll();

        for (Atencion atencion: listaAtenciones) {
            if(atencion.getCita().getCodigo()==codigoCita){
                return new AtencionMedicoDTO(atencion.getDiagnostico(), atencion.getTratamiento(),
                                            atencion.getNotasMedico(), atencion.getCita().getCodigo());
            }else{
                throw new Exception("No hay una atención para la cita ingresada");
            }
        }
           return null;
        }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
}
