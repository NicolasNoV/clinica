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
public class DiaLibre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;
}
