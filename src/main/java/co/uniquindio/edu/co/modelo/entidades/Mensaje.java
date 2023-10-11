package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "pqrs_codigo")
    private Pqrs pqrs;

    @ManyToOne
    @JoinColumn(name = "cuenta_codigo")
    private Cuenta cuenta;

    @OneToOne
    @JoinColumn(name = "mensaje_codigo")
    private Mensaje codigoMensaje;

}
