package alura.med.voll.api.dto;

public record DatosDireccion(
        String calle,
        String distrito,
        String ciudad,
        int numero,
        String complemento
) {
}
