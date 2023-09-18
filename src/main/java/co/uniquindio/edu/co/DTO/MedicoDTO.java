package co.uniquindio.edu.co.DTO;

import java.util.List;

public record MedicoDTO (
    String cedula,
    String nombre,
    String correo,
    String telefono,
    String ciudad,
    String password,
    String especialidad,
    List<HorarioDTO> horarioDTO
){

}
