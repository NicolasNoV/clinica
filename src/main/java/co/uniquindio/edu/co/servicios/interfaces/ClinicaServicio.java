package co.uniquindio.edu.co.servicios.interfaces;

import java.util.List;

public interface ClinicaServicio {

    List<String> listarCiudades() throws Exception;

    List<String> listarEps() throws Exception;

    List<String> listarEspecialidades() throws Exception;

    List<String> listarTipoSangre() throws Exception;

    List<String> listarTipoPQRS() throws Exception;

}
