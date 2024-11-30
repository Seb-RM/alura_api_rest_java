package alura.med.voll.api.controller;

import alura.med.voll.api.dto.DatosregistroMedico;
import alura.med.voll.api.model.Medico;
import alura.med.voll.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosregistroMedico datosregistroMedico) {
    medicoRepository.save(new Medico(datosregistroMedico));
    }
}
