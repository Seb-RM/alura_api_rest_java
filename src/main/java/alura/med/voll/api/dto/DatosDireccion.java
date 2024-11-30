package alura.med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotNull
        String ciudad,
        @NotNull
        Integer numero,
        @NotBlank
        String complemento
) {
}
