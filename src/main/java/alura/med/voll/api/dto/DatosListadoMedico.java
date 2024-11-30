package alura.med.voll.api.dto;

import alura.med.voll.api.model.Medico;

public record DatosListadoMedico(
        String nombre,
        String especialidad,
        String documento,
        String email
) {
    public DatosListadoMedico(Medico medico) {
        this(medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
