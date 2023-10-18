package co.uniquindio.edu.co.servicios.implementacion;

import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoCompletadaDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.DiaLibreDTO;
import co.uniquindio.edu.co.modelo.entidades.*;
import co.uniquindio.edu.co.modelo.enums.EstadoCita;
import co.uniquindio.edu.co.repositorio.AtencionRepo;
import co.uniquindio.edu.co.repositorio.CitaRepo;
import co.uniquindio.edu.co.repositorio.DiaLibreRepo;
import co.uniquindio.edu.co.repositorio.MedicoRepo;
import co.uniquindio.edu.co.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;
    private final DiaLibreRepo diaLibreRepo;
    private final MedicoRepo medicoRepo;

    @Override
    public List<CitaMedicoDTO> listarCitasPendientes(int codigo) throws Exception {
        List<Cita> listaCitas = citaRepo.findAll();
        List<CitaMedicoDTO> listaCitasPendienteMedico = new ArrayList<>();
        for (Cita cita: listaCitas) {
            if(cita.getMedico().getCodigo() == codigo){
                if(cita.getEstado().equals(EstadoCita.PROGRAMADA)){
                    listaCitasPendienteMedico.add(new CitaMedicoDTO(cita.getFechaCreacion(), cita.getFechaCita(),
                                                cita.getMotivo(), cita.getPaciente().getCedula(),
                                                cita.getMedico().getCodigo(), cita.getEstado()));
                }
            }else{
                throw new Exception("No hay un medico con el codigo: "+codigo);
            }

        }

        return listaCitasPendienteMedico;
    }

    @Override
    public int atenderCita(AtencionMedicoDTO atencionMedicoDTO) throws Exception {
        Optional<Cita> opcional = citaRepo.findById(atencionMedicoDTO.codigoCita());
        if(!(opcional.get().getFechaCita().getDayOfMonth()==(LocalDateTime.now().getDayOfMonth()))){
            throw new Exception("No se puede atender una cita que no esté agendada al dia actual");
        }
        Atencion atencion = new Atencion();
        opcional.get().setEstado(EstadoCita.COMPLETADA);
        atencion.setCita(opcional.get());
        atencion.setDiagnostico(atencionMedicoDTO.diagnostico());
        atencion.setNotasMedico(atencionMedicoDTO.notasMedico());
        atencion.setTratamiento(atencionMedicoDTO.tratamiento());

        Atencion atencionNueva = atencionRepo.save(atencion);

    return atencionNueva.getCodigo();
    }

    @Override
    public List<CitaMedicoDTO> listarCitaPaciente(int codigoPaciente) throws Exception {
        List<Cita> listaCitas = citaRepo.findAll();
        List<CitaMedicoDTO> listaCitasPaciente = new ArrayList<>();
        for(Cita cita : listaCitas){
            if(cita.getPaciente().getCodigo() == codigoPaciente){
                listaCitasPaciente.add(new CitaMedicoDTO(cita.getFechaCreacion(),cita.getFechaCita(),
                                        cita.getMotivo(),cita.getPaciente().getCedula(),cita.getMedico().getCodigo(),
                                        cita.getEstado()));

            }
        }
        return listaCitasPaciente;
    }

    @Override
    public void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        List<CitaMedicoDTO> listarCitasMedico = listarCitasPendientes(diaLibreDTO.codigoMedico());
        for(CitaMedicoDTO cita : listarCitasMedico){
            if(cita.fechaCita() == diaLibreDTO.dia()){
                throw new Exception("En el dia que intenta agendar libre tiene citas pendiente");
            }else{
                DiaLibre diaLibre = new DiaLibre();
                diaLibre.setDia(diaLibreDTO.dia());
                Optional<Medico> medico = medicoRepo.findById(cita.codigoMedico());
                diaLibre.setMedico(medico.get());
                diaLibreRepo.save(diaLibre);
            }
        }
    }

    @Override
    public List<CitaMedicoCompletadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        List<Cita> listaCitas = citaRepo.findAll();
        List<CitaMedicoCompletadaDTO> listaCitasRealizadasMedico = new ArrayList<>();
        for (Cita cita: listaCitas) {
            if(cita.getMedico().getCodigo() == codigoMedico){
                if(cita.getEstado().equals(EstadoCita.COMPLETADA)){
                    List<Atencion> ListaAtencion = atencionRepo.findAll();
                    for(Atencion atencion :ListaAtencion){
                        if(atencion.getCita().getCodigo() == cita.getCodigo()){
                            listaCitasRealizadasMedico.add(new CitaMedicoCompletadaDTO(cita.getFechaCreacion(), cita.getFechaCita(),
                                    cita.getMotivo(), cita.getPaciente().getCedula(),
                                    cita.getEstado(), atencion.getDiagnostico(), atencion.getTratamiento(), atencion.getNotasMedico()));
                        }
                    }

                }else{
                    throw new Exception("El medico no tiene ninguna cita completada: ");
                }
            }else{
                throw new Exception("No hay un medico con el codigo: "+codigoMedico);
            }

        }
        return listaCitasRealizadasMedico;
    }
}
