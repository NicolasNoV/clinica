package co.uniquindio.edu.co.servicios.interfaces;

import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.DiaLibreDTO;
import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendientes(int codigo) throws Exception;

    void atenderCita(AtencionMedicoDTO atencionMedicoDTO) throws Exception;

    List<CitaMedicoDTO> listarCitaPaciente(int codigoPaciente) throws Exception;  //Historial Medico

    void agendarDiaLibre(DiaLibreDTO diaLibreTDO) throws Exception;

    List<CitaMedicoDTO> listarCitasRealizadasMedico(int codigo) throws Exception;
}