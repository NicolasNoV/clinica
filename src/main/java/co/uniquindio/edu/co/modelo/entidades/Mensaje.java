package co.uniquindio.edu.co.modelo.entidades;

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
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotBlank
    @Column(nullable = false)
    private String contenido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pqrs_codigo")
    private Pqrs pqrs;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cuenta_codigo")
    private Cuenta cuenta;


    @OneToOne
    @JoinColumn(name = "mensaje_codigo")
    private Mensaje codigoMensaje;

}
