package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Cuenta;
import co.uniquindio.edu.co.modelo.entidades.DiaLibre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaLibreRepo extends JpaRepository<DiaLibre, Integer> {
}
