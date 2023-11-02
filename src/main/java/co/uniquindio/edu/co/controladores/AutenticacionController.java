package co.uniquindio.edu.co.controladores;

import co.uniquindio.edu.co.DTO.LoginDTO;
import co.uniquindio.edu.co.DTO.MensajeDTO;
import co.uniquindio.edu.co.DTO.TokenDTO;
import co.uniquindio.edu.co.DTO.paciente.RegistroPacienteDTO;
import co.uniquindio.edu.co.servicios.interfaces.AutenticacionServicio;
import co.uniquindio.edu.co.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AutenticacionServicio autenticacionServicio;
    private final PacienteServicio pacienteServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody LoginDTO loginDTO)
            throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.login(loginDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO registroPacienteDTO) throws Exception{
        pacienteServicio.registrarse(registroPacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente registrado correctamente") );
    }
}
