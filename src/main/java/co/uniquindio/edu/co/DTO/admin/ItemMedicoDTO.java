package co.uniquindio.edu.co.DTO.admin;

import co.uniquindio.edu.co.modelo.enums.Especialidad;

public record ItemMedicoDTO(int codigo,
                            String cedula,
                            String nombre,
                            String urlFoto,
                            Especialidad especialidad) {
}
