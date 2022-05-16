package com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.controle;

import com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.entidade.Usuario;
import com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.repositorio.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosRepository repository;

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao")
    public ResponseEntity logonUsuario(@PathVariable String login, @PathVariable String senha) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.getLogin().equals(login) && usuarioAtual.getSenha().equals(senha)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    List<Usuario> logar = repository.findByAutenticadoTrue();
                    return ResponseEntity.status(200).body(logar);
                } else {
                    return ResponseEntity.status(204).build();
                }
            }
        }
        return ResponseEntity.status(404).build();
    }


    @GetMapping
    public ResponseEntity getUsuarios() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(usuarios);
        }

    }

    @DeleteMapping("/autenticacao/{login}")
    public String logoffUsuario(@PathVariable String login) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.getLogin().equals(login)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    return String.format("Logoff do usuário %s concluído", usuarioAtual.getNome());

                } else {
                    return String.format("Usuário %s NÃO está autenticado", usuarioAtual.getNome());

                }
            }
        }
        return String.format("Usuário %s NÃO foi encontrado");
    }

    @GetMapping("/lista-passando-nome/{nome}")
    public ResponseEntity getNome(@PathVariable String nome) {
        List<Usuario> pegarNome = repository.pegaNome(nome);
        return ResponseEntity.status(200).body(pegarNome);
    }

}

