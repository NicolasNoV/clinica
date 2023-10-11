package co.uniquindio.edu.co.servicios.interfaces;

import co.uniquindio.edu.co.DTO.*;
import co.uniquindio.edu.co.DTO.admin.DetalleMedicoDTO;
import co.uniquindio.edu.co.DTO.admin.ItemCitaAdminDTO;
import co.uniquindio.edu.co.DTO.admin.ItemMedicoDTO;
import co.uniquindio.edu.co.DTO.admin.RegistroMedicoDTO;
import co.uniquindio.edu.co.modelo.enums.EstadoPQRS;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

    List<ItemCitaAdminDTO> listarCitas() throws Exception;

}
