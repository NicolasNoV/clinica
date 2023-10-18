package co.uniquindio.edu.co.servicios.interfaces;

import co.uniquindio.edu.co.DTO.LoginDTO;
import co.uniquindio.edu.co.DTO.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
