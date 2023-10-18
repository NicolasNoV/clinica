package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaCita;

    @NotBlank
    @Column(nullable = false)
    private String motivo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paciente_codigo")
    private Paciente paciente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;


}
