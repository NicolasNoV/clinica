package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EPS;
import co.uniquindio.edu.co.modelo.enums.Tipo_Sangre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha_Nacimiento;

    @NotBlank
    @Column(nullable = false)
    private String alergias;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EPS eps;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo_Sangre tipo_Sangre;

}
