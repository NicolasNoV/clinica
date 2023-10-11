package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record InfoMedicoPacienteDTO(
        @NotBlank
        String nombreMedico,
        @NotNull
        Especialidad especialidad,
        @NotNull
        List<HorarioDTO> horarioMedico

) {
}
