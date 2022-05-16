package com.exerciciocarrofk.demo.repositorio;


import com.exerciciocarrofk.demo.entidade.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
