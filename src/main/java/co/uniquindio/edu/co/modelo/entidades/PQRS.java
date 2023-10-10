package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_Creacion;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "estado_codigo")
    private EstadoPQRS estadoPQRS;

}
