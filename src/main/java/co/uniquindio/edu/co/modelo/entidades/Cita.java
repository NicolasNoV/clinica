package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaCita;

    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "paciente_cedula")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
}
