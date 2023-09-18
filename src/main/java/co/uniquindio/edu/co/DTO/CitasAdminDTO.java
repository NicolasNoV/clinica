package co.uniquindio.edu.co.DTO;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitasAdminDTO(
        int codig,
        EstadoCita estado,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
) {
}
