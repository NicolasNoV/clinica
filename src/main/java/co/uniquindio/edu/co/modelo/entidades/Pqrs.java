package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import co.uniquindio.edu.co.modelo.enums.TipoPQRS;
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
public class Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPQRS tipo;

    @NotBlank
    @Column(nullable = false)
    private String motivo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPQRS estado;

}
