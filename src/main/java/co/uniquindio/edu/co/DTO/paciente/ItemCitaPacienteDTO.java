package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.time.LocalDateTime;

public record ItemCitaPacienteDTO(
        @NotNull
    LocalDateTime fechaCreacion,

    @NotNull
    LocalDateTime fechaCita,

    @NotBlank
    String motivo,

    @NotNull
    InfoMedicoPacienteDTO infoMedicoPacienteDTO,

    @NotNull
    EstadoCita estadoCita

) {
}
