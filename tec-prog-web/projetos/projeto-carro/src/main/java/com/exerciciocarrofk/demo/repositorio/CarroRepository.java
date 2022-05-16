package com.exerciciocarrofk.demo.repositorio;

import com.exerciciocarrofk.demo.entidade.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
