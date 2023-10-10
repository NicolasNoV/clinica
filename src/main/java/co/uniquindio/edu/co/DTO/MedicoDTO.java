package co.uniquindio.edu.co.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record MedicoDTO (
    @NotNull @Length(max = 10)
    String cedula,
    @NotNull @Length(max = 200)
    String nombre,
    @NotNull @Length(max = 20) @Email
    String correo,
    @NotNull @Length(max = 20)
    int telefono,
    @NotNull @Min(0) @Max(3)
    String ciudad,
    @NotNull
    String password,
    @NotNull @Min(0) @Max(3)
    String especialidad,
    @NotNull
    String url_Foto,
    List<HorarioDTO> horarioDTO
){

}
