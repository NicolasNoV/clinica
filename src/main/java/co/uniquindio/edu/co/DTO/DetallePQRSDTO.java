package co.uniquindio.edu.co.DTO;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        LocalDateTime fecha,
        EstadoPQRS estado,
        String motivo,
        List<String> mensajes
){
}
