package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.EstadoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @NotNull
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @OneToMany
    private List<HorarioMedico> horario;
}
