package co.uniquindio.edu.co.DTO.medico;

import java.time.LocalDateTime;

public record DiaLibreDTO(
        LocalDateTime dia,
        int codigoMedico
) {

}
