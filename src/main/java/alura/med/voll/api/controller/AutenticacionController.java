package alura.med.voll.api.controller;

import alura.med.voll.api.dto.DatosAutenticacionUsusarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosAutenticacionUsusarios datosAutenticacionUsusarios){
        Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsusarios.login(),
                datosAutenticacionUsusarios.clave());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
