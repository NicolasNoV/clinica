package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioMedico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dia;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime horaInicio;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime horaFin;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

}
