package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EPS;
import co.uniquindio.edu.co.modelo.enums.Tipo_Sangre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_Nacimiento;

    @Column(nullable = false)
    private String alergias;

    @Enumerated(EnumType.STRING)
    private EPS eps;

    @Enumerated(EnumType.STRING)
    private Tipo_Sangre tipo_Sangre;

}