package alura.med.voll.api.model;

import alura.med.voll.api.dto.DatosActualizarMedico;
import alura.med.voll.api.dto.DatosregistroMedico;
import alura.med.voll.api.medico.Especialidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosregistroMedico datosregistroMedico) {
        this.nombre = datosregistroMedico.nombre();
        this.email = datosregistroMedico.email();
        this.telefono = datosregistroMedico.telefono();
        this.documento = datosregistroMedico.documento();
        this.activo = true;
        this.especialidad = datosregistroMedico.especialidad();
        this.direccion = new Direccion(datosregistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre() !=null) {
            this.nombre = datosActualizarMedico.nombre();
        }

        if(datosActualizarMedico.documento() !=null) {
            this.documento = datosActualizarMedico.documento();
        }

        if(datosActualizarMedico.direccion() !=null) {
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
