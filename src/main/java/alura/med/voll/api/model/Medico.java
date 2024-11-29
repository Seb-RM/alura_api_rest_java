package alura.med.voll.api.model;

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
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;


    public Medico(DatosregistroMedico datosregistroMedico) {
        this.nombre = datosregistroMedico.nombre();
        this.email = datosregistroMedico.email();
        this.documento = datosregistroMedico.documento();
        this.especialidad = datosregistroMedico.especialidad();
        this.direccion = new Direccion(datosregistroMedico.direccion());
    }
}
