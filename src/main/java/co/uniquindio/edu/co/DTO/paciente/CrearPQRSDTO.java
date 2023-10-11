package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.modelo.entidades.Cita;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearPQRSDTO(
       @NotBlank
        String tipo,

        @NotBlank
        String motivo,

        @NotBlank
        String codigoCita


) {
}
