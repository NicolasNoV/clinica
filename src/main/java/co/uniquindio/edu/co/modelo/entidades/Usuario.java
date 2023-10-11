package co.uniquindio.edu.co.modelo.entidades;

import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.EstadoUsuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false)
    private String url_foto;

    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;
}
