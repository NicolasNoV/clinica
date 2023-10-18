
    package co.uniquindio.edu.co.clinica.test;
import co.uniquindio.edu.co.DTO.admin.HorarioDTO;
import co.uniquindio.edu.co.DTO.admin.RegistroMedicoDTO;
import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.servicios.interfaces.AdministradorServicio;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

    @SpringBootTest
    public class AdministradorServicioTest {

        @Autowired
        private AdministradorServicio administradorServicio;

        @Test
        public void crearMedicoTest() throws Exception {
            HorarioDTO horarioDTO = new HorarioDTO(
                    LocalDateTime.of(2023,10,19,0,0),
                    LocalDateTime.of(2023,10,19,5,0),
                    LocalDateTime.of(2023,10,19,23,0)
            );
            HorarioDTO horarioDTO1 = new HorarioDTO(
                    LocalDateTime.of(2023,10,20,0,0),
                    LocalDateTime.of(2023,10,20,5,0),
                    LocalDateTime.of(2023,10,20,23,0)
            );

            List<HorarioDTO> horarios = new ArrayList<>();
            horarios.add(horarioDTO);
            horarios.add(horarioDTO1);

            RegistroMedicoDTO registroMedicoDTO = new RegistroMedicoDTO(
                    "Juan Pino",
                    "1001",
                    Ciudad.BOGOTA,
                    Especialidad.CARDIALOGIA,
                    "1000002",
                    "juanPino2@email.com",
                    "1234",
                    "url_foto",
                    horarios
            );

            int nuevo = administradorServicio.crearMedico(registroMedicoDTO);

            Assertions.assertNotEquals(0, nuevo);

        }
    }

