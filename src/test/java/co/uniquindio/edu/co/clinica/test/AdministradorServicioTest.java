
    package co.uniquindio.edu.co.clinica.test;
import co.uniquindio.edu.co.DTO.DetallePQRSDTO;
import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.admin.*;
import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.Especialidad;
import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import co.uniquindio.edu.co.servicios.interfaces.AdministradorServicio;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
                    "Carlos Jhonson",
                    "2002",
                    Ciudad.BOGOTA,
                    Especialidad.FISIOTERAPEUTA,
                    "1000002",
                    "CJ@email.com",
                    "1234",
                    "url_foto",
                    horarios
            );

            int nuevo = administradorServicio.crearMedico(registroMedicoDTO);

            Assertions.assertNotEquals(0, nuevo);

        }



        public void actualizarMedicoTest() throws Exception {

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

            DetalleMedicoDTO detalleMedicoDTO = new DetalleMedicoDTO(
                    9,
                    "Juan Arboleda",
                    "1001",
                    Ciudad.BOGOTA,
                    Especialidad.CARDIOLOGIA,
                    1000002,
                    "juanPino2@email.com",
                    "url_foto",
                    horarios
            );

            int nuevo = administradorServicio.actualizarMedico(detalleMedicoDTO);

            Assertions.assertNotEquals(0, nuevo);

        }


        public void eliminarMedicoTest() throws Exception {
            boolean respuesta = administradorServicio.eliminarMedico(9);

            Assertions.assertTrue(respuesta);
        }


        public void listarMedicosTest() throws Exception{
            List<ItemMedicoDTO> medicos = new ArrayList<>();
            medicos = administradorServicio.listarMedicos();

            Assertions.assertEquals(2, medicos.size());
        }


        public void obtenerMedicoTest() throws Exception{
            DetalleMedicoDTO detalleMedicoDTO = administradorServicio.obtenerMedico(9);
            Assertions.assertNotEquals(0, detalleMedicoDTO.codigo());
        }


        public void listarPQRSTest() throws Exception{
            List<ItemPQRSDTO> listaPQRS = administradorServicio.listarPQRS();
            Assertions.assertEquals(0, listaPQRS.size());
        }


        public void verDetallePQRSTest() throws Exception{
            DetallePQRSDTO detallePQRS = administradorServicio.verDetallePQRS(2);
            Assertions.assertNotEquals(0, detallePQRS.codigo());
        }


        public  void responderPQRSTest() throws Exception {
            RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
            9,
            2,
            2,
            "respuesta admin"
            );
            int codigo = administradorServicio.responderPQRS(registroRespuestaDTO);

            Assertions.assertNotEquals(0, codigo);
        }


        public void cambiarEstadoPQRSTest() throws Exception{
            boolean respuesta = administradorServicio.cambiarEstadoPQRS(2, EstadoPQRS.RESUELTO);
            Assertions.assertTrue(respuesta);
        }

        public void listarCitasTest() throws Exception{
            List<ItemCitaAdminDTO> listarCitas = administradorServicio.listarCitas();
            Assertions.assertEquals(0, listarCitas.size());
        }

    }

