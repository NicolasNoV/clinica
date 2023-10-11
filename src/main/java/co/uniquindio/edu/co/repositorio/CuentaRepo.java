package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer> {
}