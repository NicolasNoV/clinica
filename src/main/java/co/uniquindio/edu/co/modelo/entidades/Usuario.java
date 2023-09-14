package co.uniquindio.edu.co.modelo.entidades;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private String cedula;

    private String nombre;

    private int telefono;

    private String url_foto;

   // private Ciudad codigo_ciudad;
}
