package co.uniquindio.edu.co.DTO.admin;

import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;
public record DetalleMedicoDTO(
        @Positive
        int codigo,
        @NotEmpty
        @Length(max = 200)
        String nombre,
        @NotEmpty
        @Length(max = 10)
        String cedula,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotEmpty
        @Length(max = 20)
        int telefono,
        @NotEmpty
        @Email
        @Length(max = 80)
        String correo,
        @NotEmpty
        String urlFoto,
        @NotEmpty
        List<HorarioDTO> horarios
) {
}
