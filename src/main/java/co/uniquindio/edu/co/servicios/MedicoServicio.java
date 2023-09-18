package co.uniquindio.edu.co.servicios;

import co.uniquindio.edu.co.DTO.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.CitaMedicoTDO;
import co.uniquindio.edu.co.DTO.DiaLibreTDO;
import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoTDO> listarCitasPendientes(int codigo) throws Exception;

    void atenderCita(AtencionMedicoDTO atencionMedicoDTO) throws Exception;

    List<CitaMedicoTDO> listarCitaPaciente(int codigoPaciente) throws Exception;  //Historial Medico

    void agendarDiaLibre(DiaLibreTDO diaLibreTDO) throws Exception;

    List<CitaMedicoTDO> listarCitasRealizadasMedico(int codigo) throws Exception;
}