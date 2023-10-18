package co.uniquindio.edu.co.DTO.medico;

import co.uniquindio.edu.co.modelo.entidades.Atencion;
import co.uniquindio.edu.co.modelo.enums.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CitaMedicoCompletadaDTO(
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        LocalDateTime fechaCita,
        @NotBlank
        String motivo,
        @NotBlank
        String cedulaPaciente,
        @NotNull
        EstadoCita estado,
        @NotBlank
        String diagnostico,
        @NotBlank
        String tratamiento,
        @NotBlank
        String notasMedico


) {
}
