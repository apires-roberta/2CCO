package com.exerciciocarrofk.demo.repositorio;

import com.exerciciocarrofk.demo.entidade.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
