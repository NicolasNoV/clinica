package co.uniquindio.edu.co.DTO.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NuevaPasswordDTO(
        @NotBlank
        String correo,
        @NotBlank
        String nuevaPassword
) {
}
