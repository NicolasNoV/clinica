package co.uniquindio.edu.co.DTO.admin;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitasAdminDTO(
        int codigo,
        EstadoCita estado,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
) {
}
