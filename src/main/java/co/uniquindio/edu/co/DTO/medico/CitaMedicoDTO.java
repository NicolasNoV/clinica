package co.uniquindio.edu.co.DTO.medico;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitaMedicoDTO(
        LocalDateTime fechaCreacion,
        LocalDateTime fechaCita,
        String motivo,
        String cedulaPaciente,
        int codigoMedico,
        EstadoCita estado
) {
}
