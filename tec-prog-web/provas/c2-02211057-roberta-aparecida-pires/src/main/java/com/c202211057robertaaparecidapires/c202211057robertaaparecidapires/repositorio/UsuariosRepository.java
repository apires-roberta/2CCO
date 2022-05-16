package com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.repositorio;

import com.c202211057robertaaparecidapires.c202211057robertaaparecidapires.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuariosRepository
        extends JpaRepository<Usuario, Integer> {
    @Query("select s from Usuario s where s.nome = ?1")
    List<Usuario> pegaNome(String nome);

    //@Query("update u Usuario set d.autenticado = true where u.login = ?1 and u.senha = ?2")
    List<Usuario> findByAutenticadoTrue();

}
