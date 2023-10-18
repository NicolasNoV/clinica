package co.uniquindio.edu.co.DTO.serviciosExternos;

public record EmailDTO(
        String asunto,
        String cuerpo,
        String destinatario
) {
}
