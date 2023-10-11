package co.uniquindio.edu.co.DTO;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

    public record ItemPQRSDTO(int codigo,
                              EstadoPQRS estado,
                              String motivo,
                              LocalDateTime fecha,
                              String nombrePaciente){
    }


