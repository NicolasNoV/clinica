package co.uniquindio.edu.co.servicios.implementacion;

import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.paciente.*;
import co.uniquindio.edu.co.modelo.entidades.*;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import co.uniquindio.edu.co.modelo.enums.EstadoUsuario;
import co.uniquindio.edu.co.modelo.enums.TipoPQRS;
import co.uniquindio.edu.co.repositorio.*;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;
    private final CitaRepo citaRepo;
    private final HorarioRepo horarioRepo;
    private final PacienteRepo pacienteRepo;
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
        paciente.setPassword(registroPacienteDTO.password());
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
        buscado.setPassword(detallePacienteDTO.password());

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
    buscado.setPassword(nuevaPasswordDTO.nuevaPassword());
    pacienteRepo.save(buscado);

    }

    @Override
    public void agendarCitas(AgendarCitaDTO agendarCitaDTO) throws Exception {

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
        Optional<Cita> opcional =citaRepo.findById(Integer.valueOf(crearPQRSDTO.codigoCita()));
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        for (Pqrs pqrs:listaPqrs) {
            if(pqrs.getCita().getPaciente().getCodigo()==opcional.get().getPaciente().getCodigo()){
                contador++;
            }
        }
        if(contador <3){
            Pqrs pqrs = new Pqrs();
            pqrs.setEstado(EstadoPQRS.NUEVO);
            pqrs.setTipo(TipoPQRS.valueOf(crearPQRSDTO.tipo()));
            pqrs.setCita(opcional.get());
            pqrs.setMotivo(crearPQRSDTO.motivo());
            pqrs.setFechaCreacion(LocalDateTime.now());
            pqrsRepo.save(pqrs);
        }
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaPacienteDTO> listarCitasPaciente() {
        return null;
    }

    @Override
    public List<ItemCitaPacienteDTO> filtrarCitasPorFecha(LocalDateTime fecha) {
        return null;
    }

    @Override
    public List<ItemCitaPacienteDTO> filtrarCitasPorMedico(int CodigoMedico) {
        return null;
    }

    @Override
    public AtencionMedicoDTO verDetalleCita(int codigoCita) {
        return null;
    }
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
}
