package co.uniquindio.edu.co.servicios;

import co.uniquindio.edu.co.DTO.EmailDTO;

public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;
}
