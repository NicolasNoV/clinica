package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQRSRepo extends JpaRepository<Pqrs, Integer> {
}
