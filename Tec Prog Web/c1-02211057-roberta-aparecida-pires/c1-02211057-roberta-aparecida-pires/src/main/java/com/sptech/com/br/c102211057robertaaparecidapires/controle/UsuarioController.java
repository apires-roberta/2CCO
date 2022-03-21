package com.sptech.com.br.c102211057robertaaparecidapires.controle;

import com.sptech.com.br.c102211057robertaaparecidapires.entidade.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PostMapping
    public String postUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return "Usuário " + novoUsuario.getNome() + " cadastrado com sucesso";
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public String autenticandoUsuario(@PathVariable String usuario,
                                      @PathVariable String senha) {
        for (int interador = 0; interador <= usuarios.size(); interador++) {
            if (usuario.equals(usuarios.get(interador).getUsuario())) {
                if (senha.equals(usuarios.get(interador).getSenha()))
                    usuarios.get(interador).setAutenticar(true);
                return "Usuário " + usuarios.get(interador).getNome() + "agora está autenticado";

            } else {
                usuarios.get(interador).setAutenticar(false);
                return "Usuário" + usuario + " não encontrado";
            }

        }
        return "ok";
    }


        @DeleteMapping("/autenticacao/{usuario}")
        public String delUsuario (@PathVariable String usuario){
            if (usuario.isEmpty()) {
                return "Usuário " + usuario + " não encontrado";
            } else if (getUsuarios().equals(usuario)) {
                getUsuarios().remove(usuario);
                return "Logoff do usuário " + usuario + " concluído";
            } else {
                return "Usuário " + usuario + " NÃO está autenticado";
            }

        }


    }
