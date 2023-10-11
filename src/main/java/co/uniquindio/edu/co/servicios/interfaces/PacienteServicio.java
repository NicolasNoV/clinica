package co.uniquindio.edu.co.servicios.interfaces;

import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.paciente.*;

import java.time.LocalDateTime;
import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    void enviarLinkRecuperacion();

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    void agendarCitas(AgendarCitaDTO agendarCitaDTO) throws Exception;

    List<InfoMedicoPacienteDTO> listarMedicosEspecialidad (String especialidad) throws Exception;

    void crearPQRS(CrearPQRSDTO crearPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaPacienteDTO> listarCitasPaciente();

    List<ItemCitaPacienteDTO> filtrarCitasPorFecha(LocalDateTime fecha);

    List<ItemCitaPacienteDTO> filtrarCitasPorMedico(int CodigoMedico);

    AtencionMedicoDTO verDetalleCita(int codigoCita);
}