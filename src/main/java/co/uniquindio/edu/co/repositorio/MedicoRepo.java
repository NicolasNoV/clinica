package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {
    Medico findByCorreo(String correo);

    Medico findByCedula(String cedula);
}
