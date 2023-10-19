package co.uniquindio.edu.co.clinica.test;

import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoCompletadaDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.DiaLibreDTO;
import co.uniquindio.edu.co.DTO.paciente.AgendarCitaDTO;
import co.uniquindio.edu.co.servicios.interfaces.MedicoServicio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    public void listarCitasPendientesTest() throws Exception {
        List<CitaMedicoDTO> listasCitasPendientes = medicoServicio.listarCitasPendientes(9);
        Assertions.assertEquals(1, listasCitasPendientes.size());
    }


    public void atenderCitaTest() throws Exception{
        AtencionMedicoDTO atencionMedicoDTO = new AtencionMedicoDTO("3 días de vida","Acetaminofén","Ya pailas",
        1);
        int codigo = medicoServicio.atenderCita(atencionMedicoDTO );
        Assertions.assertNotEquals(0,codigo);
    }


    public void listarCitaPacienteTest() throws Exception{
        List<CitaMedicoDTO> listarCitaPaciente = medicoServicio.listarCitaPaciente(10);
        Assertions.assertEquals(1, listarCitaPaciente.size());
    }

    public void agendarDiaLibreTest() throws Exception{
        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(LocalDateTime.of(2023, 10,20,0,0), 9);
        boolean respuesta = medicoServicio.agendarDiaLibre(diaLibreDTO);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void listarCitasRealizadasMedicoTest() throws Exception{
        List<CitaMedicoCompletadaDTO> listasCitasRealizadasMedico = medicoServicio.listarCitasRealizadasMedico(9);
        Assertions.assertEquals(1,listasCitasRealizadasMedico.size());
    }
    }
