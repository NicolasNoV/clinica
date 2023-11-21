package co.uniquindio.edu.co.controladores;

import co.uniquindio.edu.co.DTO.MensajeDTO;
import co.uniquindio.edu.co.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
@RequiredArgsConstructor
public class ClinicaController {

    private final ClinicaServicio clinicaServicio;

    @GetMapping("/listar-ciudades")
    public ResponseEntity<MensajeDTO<List<String>>> listarCiudades() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarCiudades()) );
    }
    @GetMapping("/listar-eps")
    public ResponseEntity<MensajeDTO<List<String>>> listarEps() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarEps()) );
    }
    @GetMapping("/listar-especialidades")
    public ResponseEntity<MensajeDTO<List<String>>> listarEspecialidades() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarEspecialidades()) );
    }
    @GetMapping("/listar-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<String>>> listarTipoSangre() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarTipoSangre()) );
    }
    @GetMapping("/listar-tipo-pqrs")
    public ResponseEntity<MensajeDTO<List<String>>> listarTipoPQRS() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clinicaServicio.listarTipoPQRS()) );
    }

}
