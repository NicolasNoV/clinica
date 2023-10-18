package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.modelo.entidades.Medico;
import co.uniquindio.edu.co.modelo.entidades.Paciente;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendarCitaDTO(
       @NotNull
        LocalDateTime fechaCita,
       @NotBlank
       String motivo,
       @NotNull
       Medico medico,
       @NotNull
       int codigoPaciente
) {
}
