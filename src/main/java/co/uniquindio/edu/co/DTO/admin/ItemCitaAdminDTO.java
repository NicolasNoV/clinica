package co.uniquindio.edu.co.DTO.admin;

import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(

        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha

) {
}