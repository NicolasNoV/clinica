package co.uniquindio.edu.co.DTO.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtencionMedicoDTO(
        @NotBlank
        String diagnostico,
        @NotBlank
        String tratamiento,
        @NotBlank
        String notasMedico,
        @NotNull
        int codigoCita
) {
}
