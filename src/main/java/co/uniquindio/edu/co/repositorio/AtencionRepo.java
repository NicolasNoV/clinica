package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionRepo extends JpaRepository<Atencion, Integer> {

}
