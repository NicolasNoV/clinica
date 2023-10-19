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

    boolean eliminarCuenta(int codigo) throws Exception;

    boolean enviarLinkRecuperacion(String correo) throws Exception;

    boolean cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    boolean agendarCitas(AgendarCitaDTO agendarCitaDTO) throws Exception;

    List<InfoMedicoPacienteDTO> listarMedicosEspecialidad (String especialidad) throws Exception;

    boolean crearPQRS(CrearPQRSDTO crearPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRS(int codigoCliente) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    List<ItemCitaPacienteDTO> filtrarCitasPorFecha(LocalDateTime fecha) throws Exception;

    List<ItemCitaPacienteDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception;

    AtencionMedicoDTO verDetalleCita(int codigoCita) throws Exception;
}