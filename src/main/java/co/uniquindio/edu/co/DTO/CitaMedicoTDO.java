package co.uniquindio.edu.co.DTO;

import java.time.LocalDateTime;

public record CitaMedicoTDO(
        LocalDateTime fechaCreacion,
        LocalDateTime fechaCita,
        String motivo,
        String cedulaPaciente,
        String codigoMedico,
        String codigoEstado
) {
}
