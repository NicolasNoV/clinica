package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime dia;

    @Column(nullable = false)
    private LocalDateTime hora_Inicio;

    @Column(nullable = false)
    private LocalDateTime hora_Fin;

    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;
}
