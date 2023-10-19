package co.uniquindio.edu.co.clinica.test;

import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.paciente.*;
import co.uniquindio.edu.co.modelo.enums.Ciudad;
import co.uniquindio.edu.co.modelo.enums.EPS;
import co.uniquindio.edu.co.modelo.enums.Tipo_Sangre;
import co.uniquindio.edu.co.servicios.interfaces.AdministradorServicio;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
@SpringBootTest
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    public void registrarseTest() throws Exception{
        RegistroPacienteDTO registroPacienteDTO = new RegistroPacienteDTO(
                        "Susana Gutierrez",
                        "5005",
                        Ciudad.MEDELLIN,
                        Tipo_Sangre.OPOSITIVO,
                        "0876513",
                        "susanaGut@email.com",
                        "123",
                        "url_foto",
                        "Ninguna",
                        EPS.NUEVAEPS,
                        LocalDateTime.of(2006,9,14,0,0)
        );
        int nuevo = pacienteServicio.registrarse(registroPacienteDTO);
        Assertions.assertNotEquals(0, nuevo);
    }

    public void editarPerfilTest() throws Exception{

        DetallePacienteDTO detallePacienteDTO = new DetallePacienteDTO(
        10,
        "Susana Castro",
        "3003",
        Ciudad.CALI,
        Tipo_Sangre.ABPOSITIVO ,
        "124345623",
        "susanaCas@email.com",
        "123",
        "url_foto",
        "Mani",
        EPS.SANITAS,
                LocalDateTime.of(2008,8,24,0,0)
        );
        int nuevo = pacienteServicio.editarPerfil(detallePacienteDTO);
        Assertions.assertNotEquals(0, nuevo);
    }

    public void eliminarCuentaTest() throws Exception{
        boolean respuesta = pacienteServicio.eliminarCuenta(10);
        Assertions.assertTrue(respuesta);
    }

    public void enviarLinkRecuperacion() throws Exception{
        boolean respuesta = pacienteServicio.enviarLinkRecuperacion("susanaCas@email.com");
        Assertions.assertTrue(respuesta);
    }

    public void cambiarPasswordTest() throws Exception{
        NuevaPasswordDTO nuevaPasswordDTO = new NuevaPasswordDTO(
                        "susanaG@email.com",
                        "12345"
        );

        boolean respuesta = pacienteServicio.cambiarPassword(nuevaPasswordDTO);
        Assertions.assertTrue(respuesta);
    }


    public void agendarCitasTest() throws Exception{
        AgendarCitaDTO agendarCitaDTO = new AgendarCitaDTO(
                LocalDateTime.of(2023,10,18,9,30),
                "Dolor agudo en el estomago",
                9,
                10
        );
        boolean respuesta = pacienteServicio.agendarCitas(agendarCitaDTO);
        Assertions.assertTrue(respuesta);
    }

    public void listarMedicosEspecialidadTest() throws Exception{
        List<InfoMedicoPacienteDTO> medicosEspecialidad = pacienteServicio.listarMedicosEspecialidad("CARDIOLOGIA");
        Assertions.assertEquals(1, medicosEspecialidad.size());
    }

    public void crearPQRSTest() throws Exception{
        CrearPQRSDTO crearPQRSDTO = new CrearPQRSDTO(
                "PREGUNTA",
                "Quiero saber como recibir mi historial medico",
                "1"
        );
        boolean respuesta = pacienteServicio.crearPQRS(crearPQRSDTO);
        Assertions.assertTrue(respuesta);
    }


    public void listarPQRSTest() throws Exception{
        List<ItemPQRSDTO> listaPQRS = pacienteServicio.listarPQRS(10);
        Assertions.assertEquals(4, listaPQRS.size());
    }


    public void responderPQRSTest() throws Exception{
        RegistroRespuestaDTO registroRespuestaDTO = new RegistroRespuestaDTO(
        9,
        6,
        1,
        "Muchas gracias por su respuesta"
        );
        int codigo = pacienteServicio.responderPQRS(registroRespuestaDTO);
        Assertions.assertNotEquals(0, codigo);
    }


    public void listarCitasPacienteTest() throws Exception{
        List<ItemCitaPacienteDTO> listaCitas = pacienteServicio.listarCitasPaciente(10);
        Assertions.assertEquals(1, listaCitas.size());
    }


    public void filtrarCitasPorFechaTest() throws Exception{
        List<ItemCitaPacienteDTO> listaCitasFecha = pacienteServicio.filtrarCitasPorFecha(LocalDateTime.of(2023,10,18,9,30));
        Assertions.assertEquals(1, listaCitasFecha.size());
    }

    public void filtrarCitasPorMedicoTest() throws Exception{
        List<ItemCitaPacienteDTO> listaCitasMedico = pacienteServicio.filtrarCitasPorMedico(9);
        Assertions.assertEquals(1, listaCitasMedico.size());
    }

    @Test
    public void verDetalleCitaTest() throws Exception{
        AtencionMedicoDTO atencion = pacienteServicio.verDetalleCita(1);
        Assertions.assertNotEquals(0, atencion.codigoCita());
    }
}
