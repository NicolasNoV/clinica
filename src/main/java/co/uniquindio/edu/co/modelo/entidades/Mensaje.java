package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_Creacion;

    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "pqrs_codigo")
    private PQRS pqrs;

    @ManyToOne
    @JoinColumn(name = "cuenta_codigo")
    private Cuenta cuenta;

    @OneToOne
    @JoinColumn(name = "mensaje_codigo")
    private int codigoMensaje;

}
