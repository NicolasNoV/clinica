package co.uniquindio.edu.co.controladores;

import co.uniquindio.edu.co.DTO.MensajeDTO;
import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoCompletadaDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.DiaLibreDTO;
import co.uniquindio.edu.co.DTO.paciente.InfoMedicoPacienteDTO;
import co.uniquindio.edu.co.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medico")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoServicio medicoServicio;
    @GetMapping("/listar-citas-pendientes/{codigo}")
    public ResponseEntity<MensajeDTO<List<CitaMedicoDTO>>> listarCitasPendientes(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitasPendientes(codigo)) );
    }
    @PostMapping("/atender-cita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody AtencionMedicoDTO atencionMedicoDTO) throws Exception{
        medicoServicio.atenderCita(atencionMedicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha atendido la cita correctamente"));
    }
    @GetMapping("/listar-cita-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<CitaMedicoDTO>>> listarCitaPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitaPaciente(codigoPaciente)) );
    }
    @PostMapping("/agendar-dia-libre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreTDO) throws Exception{
        medicoServicio.agendarDiaLibre(diaLibreTDO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha agendado el dia libre correctamente"));
    }
    @GetMapping("/listar-citas-realizadas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<CitaMedicoCompletadaDTO>>> listarCitasRealizadasMedico(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitasRealizadasMedico(codigoMedico)) );
    }
}
