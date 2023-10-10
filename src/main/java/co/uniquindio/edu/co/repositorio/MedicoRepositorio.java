package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
    @Query("select m from Medico m where m.cedula = :cedula")
    Medico buscarPorCedula(String cedula);

    @Query("select m from Medico m where m.correo = :correo")
    Medico buscarPorCorreo(String correo);
}
