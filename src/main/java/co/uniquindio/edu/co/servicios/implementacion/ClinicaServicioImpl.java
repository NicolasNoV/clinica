package co.uniquindio.edu.co.servicios.implementacion;

import co.uniquindio.edu.co.modelo.enums.*;
import co.uniquindio.edu.co.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClinicaServicioImpl implements ClinicaServicio {
    @Override
    public List<String> listarCiudades() throws Exception {

        Ciudad[] ciudades = Ciudad.values();

        String[] ciudadesAux = new String[ciudades.length];

        for (int i = 0; i < ciudades.length; i++) {
            ciudadesAux[i] = ciudades[i].name();
        }
        return Arrays.asList(ciudadesAux);
    }

    @Override
    public List<String> listarEps() throws Exception {
        EPS[] eps = EPS.values();

        String[] epsAux = new String[eps.length];

        for (int i = 0; i < eps.length; i++) {
            epsAux[i] = eps[i].name();
        }
        return Arrays.asList(epsAux);
    }

    @Override
    public List<String> listarEspecialidades() throws Exception {
        Especialidad[] especialidad = Especialidad.values();

        String[] especialidadAux = new String[especialidad.length];

        for (int i = 0; i < especialidad.length; i++) {
            especialidadAux[i] = especialidad[i].name();
        }
        return Arrays.asList(especialidadAux);
    }

    @Override
    public List<String> listarTipoSangre() throws Exception {
        Tipo_Sangre[] tipoSangre = Tipo_Sangre.values();

        String[] tipoSangredAux = new String[tipoSangre.length];

        for (int i = 0; i < tipoSangre.length; i++) {
            tipoSangredAux[i] = tipoSangre[i].name();
        }
        return Arrays.asList(tipoSangredAux);
    }

    @Override
    public List<String> listarTipoPQRS() throws Exception {
        TipoPQRS[] tipoPQRS = TipoPQRS.values();

        String[] tipoPQRSAux = new String[tipoPQRS.length];

        for (int i = 0; i < tipoPQRS.length; i++) {
            tipoPQRSAux[i] = tipoPQRS[i].name();
        }
        return Arrays.asList(tipoPQRSAux);
    }


}
