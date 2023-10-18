package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoCitasPacienteDTO(
        @NotBlank
        String nombreMedico,

        @NotNull
        Especialidad especialidad
) {
}
