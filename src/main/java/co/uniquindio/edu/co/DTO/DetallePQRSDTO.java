package co.uniquindio.edu.co.DTO;

import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes
){
}
