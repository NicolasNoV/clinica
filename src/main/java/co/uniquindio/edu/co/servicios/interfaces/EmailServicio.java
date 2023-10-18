package co.uniquindio.edu.co.servicios.interfaces;

import co.uniquindio.edu.co.DTO.serviciosExternos.EmailDTO;

public interface EmailServicio {

    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
