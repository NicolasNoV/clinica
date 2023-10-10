package co.uniquindio.edu.co.servicios.implementacion;

import co.uniquindio.edu.co.DTO.*;
import co.uniquindio.edu.co.modelo.entidades.Medico;
import co.uniquindio.edu.co.repositorio.MedicoRepositorio;
import co.uniquindio.edu.co.servicios.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepositorio medicoRepositorio;

    @Override
    public int crearMedico(MedicoDTO medico) throws Exception {

        Medico medicoNuevo = new Medico();

        medicoNuevo.setCedula(medico.cedula());
        medicoNuevo.setNombre(medico.nombre());
        medicoNuevo.setTelefono(medico.telefono());
        medicoNuevo.setUrl_foto(medico.url_Foto());
        medicoNuevo.setCodigo_Especialidad(medico.especialidad());

        medicoNuevo.setCorreo(medico.correo());
        medicoNuevo.setPassword(medico.password());

        if(estaRepetidoCorreo(medico.correo())){
            throw new Exception("El correo ya está en uso");
        }
        if(estaRepetidoCedula(medico.cedula())){
            throw new Exception("La cedula ya está en uso");
        }

        Medico medicoRegistrado = medicoRepositorio.save(medicoNuevo);
        return medicoRegistrado.getCodigo();
    }

    private boolean estaRepetidoCedula(String cedula) {
        medicoRepositorio.buscarPorCedula();
    }

    private boolean estaRepetidoCorreo(String correo) {
        medicoRepositorio.buscarPorCorreo();
    }

    @Override
    public int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception {
        return 0;
    }

    @Override
    public String eliminarMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<InfoMedicoAdminDTO> listarMedicos() throws Exception {
        return null;
    }

    @Override
    public DetalleMedicoDTO obtenerMedicos(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<PQRSAdminDTO> listarPQRS() throws Exception {
        return null;
    }

    @Override
    public String responderPQRS(RespuestaPQRSDTO respuesta) throws Exception {
        return null;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<CitasAdminDTO> listarCitas() throws Exception {
        return null;
    }
}
