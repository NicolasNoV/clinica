package co.uniquindio.edu.co.DTO;

import java.time.LocalDateTime;

public record RespuestaDTO (
        int codigoMensaje,
        String mensaje,
        String nombreUsuario,
        LocalDateTime fecha) {
}
