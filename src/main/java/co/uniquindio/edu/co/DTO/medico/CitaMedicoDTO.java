package co.uniquindio.edu.co.DTO.medico;

import java.time.LocalDateTime;

public record CitaMedicoDTO(
        LocalDateTime fechaCreacion,
        LocalDateTime fechaCita,
        String motivo,
        String cedulaPaciente,
        String codigoMedico,
        String codigoEstado
) {
}
