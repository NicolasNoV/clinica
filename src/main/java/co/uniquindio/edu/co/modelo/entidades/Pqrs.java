package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import co.uniquindio.edu.co.modelo.enums.TipoPQRS;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pqrs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private TipoPQRS tipo;

    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

    @Enumerated(EnumType.STRING)
    private EstadoPQRS estado;


}
