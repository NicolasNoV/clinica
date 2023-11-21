package co.uniquindio.edu.co.controladores;

import co.uniquindio.edu.co.DTO.DetallePQRSDTO;
import co.uniquindio.edu.co.DTO.ItemPQRSDTO;
import co.uniquindio.edu.co.DTO.MensajeDTO;
import co.uniquindio.edu.co.DTO.RegistroRespuestaDTO;
import co.uniquindio.edu.co.DTO.admin.DetalleMedicoDTO;
import co.uniquindio.edu.co.DTO.admin.ItemCitaAdminDTO;
import co.uniquindio.edu.co.DTO.admin.ItemMedicoDTO;
import co.uniquindio.edu.co.DTO.admin.RegistroMedicoDTO;
import co.uniquindio.edu.co.DTO.medico.CitaMedicoDTO;
import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;
import co.uniquindio.edu.co.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admins")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

    @PostMapping("/crear-medico")
    public ResponseEntity<MensajeDTO<String>> crearMedico(@Valid @RequestBody RegistroMedicoDTO medicoDTO) throws Exception{
        administradorServicio.crearMedico(medicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha creado un medico correctamente"));
    }
    @PutMapping("/actualizar-medico")
    public ResponseEntity<MensajeDTO<String>> actualizarMedico(@Valid @RequestBody DetalleMedicoDTO medicoDTO) throws Exception{
        administradorServicio.actualizarMedico(medicoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha modificado un medico correctamente"));
    }
    @DeleteMapping("/eliminar-medico/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarMedico(@PathVariable int codigo) throws Exception{
        administradorServicio.eliminarMedico(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha eliminado un medico correctamente"));
    }
    @GetMapping("/listar-medicos")
    public ResponseEntity<MensajeDTO<List<ItemMedicoDTO>>> listarMedicos() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarMedicos()) );
    }
    @GetMapping("/obtener-medico/{codigo}")
    public ResponseEntity<MensajeDTO<String>> obtenerMedico(@PathVariable int codigo) throws Exception{
        administradorServicio.obtenerMedico(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha obtenido el medico correctamente"));
    }
    @GetMapping("/listar-pqrs")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRS() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarPQRS()) );
    }
    @GetMapping("/ver-detalle-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO<String>> verDetallePQRS(@PathVariable int codigo) throws Exception{
        administradorServicio.verDetallePQRS(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Ha obtenido los detalles de la pqrs correctamente"));
    }
    @PostMapping("/responder-pqrs")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        administradorServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se respondió la pqrs correctamente"));
    }
    @PutMapping("/cambiar-estado-pqrs/{codigoPQRS}{estadoPQRS}")
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPQRS(@PathVariable int codigoPQRS, @PathVariable EstadoPQRS estadoPQRS) throws Exception{
        administradorServicio.cambiarEstadoPQRS(codigoPQRS,estadoPQRS);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se cambio el estado de la pqrs correctamente"));
    }
    @GetMapping("/listar-citas")
    ResponseEntity<MensajeDTO<List<ItemCitaAdminDTO>>> listarCitas() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarCitas()) );
    }
}
