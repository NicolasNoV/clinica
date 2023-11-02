package co.uniquindio.edu.co.controladores;

import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.MensajeDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.medico.AtencionMedicoDTO;
import co.uniquindio.edu.co.DTO.paciente.*;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO detallePacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(detallePacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado correctamete") );
    }
    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete"));
    }
    @GetMapping("/link-recuperacion/{correo}")
    public ResponseEntity<MensajeDTO<String>> enviarLinkRecuperacion(@PathVariable String correo) throws Exception{
        pacienteServicio.enviarLinkRecuperacion(correo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha enviado el link de recuperacion correctamente"));
    }
    @PutMapping("/cambiar-password")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody NuevaPasswordDTO nuevaPasswordDTO) throws Exception{
        pacienteServicio.cambiarPassword(nuevaPasswordDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha cambiado la contraseña correctamente"));
    }
    @PostMapping("/agendar-citas")
    public ResponseEntity<MensajeDTO<String>> agendarCitas(@Valid @RequestBody AgendarCitaDTO agendarCitaDTO) throws Exception{
        pacienteServicio.agendarCitas(agendarCitaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha agendado la cita correctamente"));
    }
    @GetMapping("listar-medicos-especialidad/{especialidad}")
    public ResponseEntity<MensajeDTO<List<InfoMedicoPacienteDTO>>> listarMedicosEspecialidad (@PathVariable String especialidad) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.listarMedicosEspecialidad(especialidad)) );
    }
    @PostMapping("/crear-pqrs")
    public ResponseEntity<MensajeDTO<String>> crearPQRS(@Valid @RequestBody CrearPQRSDTO crearPQRSDTO) throws Exception{
        pacienteServicio.crearPQRS(crearPQRSDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha creado la pqrs correctamente"));
    }
    @GetMapping("/listar-pqrs/{codigoCliente}")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRS(@PathVariable int codigoCliente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.listarPQRS(codigoCliente)) );
    }
    @PutMapping("/responder-pqrs")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        pacienteServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha creado la respuesta correctamente"));
    }
    @GetMapping("/listar-citas-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaPacienteDTO>>> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.listarCitasPaciente(codigoPaciente)) );
    }
    @GetMapping("/filtrar-citas-por-fecha/{fecha}")
    public ResponseEntity<MensajeDTO<List<ItemCitaPacienteDTO>>> filtrarCitasPorFecha(@PathVariable LocalDateTime fecha) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorFecha(fecha)) );
    }
    @GetMapping("/filtrar-citas-por-medico/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaPacienteDTO>>> filtrarCitasPorMedico(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorMedico(codigoMedico)) );
    }
    @GetMapping("/ver-detalle-cita/{codigoCita}")
    public ResponseEntity<MensajeDTO<AtencionMedicoDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.verDetalleCita(codigoCita)) );
    }
}
