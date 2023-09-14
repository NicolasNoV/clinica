package co.uniquindio.edu.co.servicios;

public interface MedicoServicio {

    void listarCitasPendientes();

    void atenderCita();

    void listarCitaPaciente();  //Historial Medico

    void agendarDiaLibre();

    void listarCitasRealizadasMedico();
}