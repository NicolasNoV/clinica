package co.uniquindio.edu.co.DTO;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record PQRSAdminDTO(
        int codig,
        String tipo,
        LocalDateTime fecha,
        EstadoPQRS estadoPQRS
) {
}
