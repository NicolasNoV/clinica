package co.uniquindio.edu.co.DTO.paciente;

import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.EPS;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.Tipo_Sangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RegistroPacienteDTO(
    @NotBlank
    @Length(max = 200)
    String nombre,
    @NotBlank
    @Length(max = 10)
    String cedula,
    @NotNull
    Ciudad ciudad,
    @NotNull
    Tipo_Sangre tipoSangre ,
    @NotBlank
    @Length(max = 20)
    String telefono,
    @NotBlank
    @Email
    @Length(max = 80)
    String correo,
    @NotBlank
    String password,
    @NotBlank
    String urlFoto,
    @NotBlank
    String alergias,
    @NotNull
    EPS eps
){
}
