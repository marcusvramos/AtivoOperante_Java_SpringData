package org.example.ativooperante.restcontrollers;

import org.example.ativooperante.db.entities.Usuario;
import org.example.ativooperante.security.JWTTokenProvider;
import org.example.ativooperante.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AccessController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    ResponseEntity<Object> logar(@RequestBody Usuario loginRequest) {
        Usuario usuario = usuarioService.findByEmail(loginRequest.getEmail());
        if (usuario != null && Objects.equals(usuario.getSenha(), loginRequest.getSenha())) {
            String token = JWTTokenProvider.getToken(usuario.getEmail(), "" + usuario.getNivel(), usuario.getId());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}

