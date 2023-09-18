package co.uniquindio.edu.co.DTO;

import java.util.List;

public record DetalleMedicoDTO(
        String cedula,
        String nombre,
        String correo,
        String telefono,
        String ciudad,
        String especialidad,
        List<HorarioDTO> horarioDTO
) {
}
