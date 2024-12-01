package alura.med.voll.api.controller;

import alura.med.voll.api.dto.DatosActualizarMedico;
import alura.med.voll.api.dto.DatosListadoMedico;
import alura.med.voll.api.dto.DatosregistroMedico;
import alura.med.voll.api.model.Medico;
import alura.med.voll.api.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosregistroMedico datosregistroMedico) {
    medicoRepository.save(new Medico(datosregistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
}
