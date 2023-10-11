package co.uniquindio.edu.co.DTO.serviciosExternos;

public record EmailDTO(
        String mensaje,
        String para,
        String asunto,
        String de
) {
}
