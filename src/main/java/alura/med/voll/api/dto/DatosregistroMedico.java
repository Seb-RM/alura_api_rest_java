package alura.med.voll.api.dto;

import alura.med.voll.api.medico.Especialidad;

public record DatosregistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion

) {
}
