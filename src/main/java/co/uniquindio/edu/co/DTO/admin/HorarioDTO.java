package co.uniquindio.edu.co.DTO.admin;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record HorarioDTO (
        LocalDateTime dia,
        LocalDateTime horaInicio,
        LocalDateTime horaSalida) {
}

