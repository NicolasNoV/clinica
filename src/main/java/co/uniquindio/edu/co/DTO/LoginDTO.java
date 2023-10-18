package co.uniquindio.edu.co.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String correo,
        @NotBlank
        String password
) {
}
