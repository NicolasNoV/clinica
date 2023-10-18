package co.uniquindio.edu.co.DTO;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
