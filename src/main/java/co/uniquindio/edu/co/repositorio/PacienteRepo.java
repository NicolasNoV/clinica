package co.uniquindio.edu.co.repositorio;

import co.uniquindio.edu.co.modelo.entidades.Medico;
import co.uniquindio.edu.co.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
    Paciente findByCorreo(String correo);

    Paciente findByCedula(String cedula);
}
