package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotBlank
    @Column(nullable = false)
    private String diagnostico;

    @NotBlank
    @Column(nullable = false)
    private String tratamiento;

    @NotBlank
    @Column(nullable = false)
    private String notasMedico;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;
}
