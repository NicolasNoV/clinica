package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {
}
