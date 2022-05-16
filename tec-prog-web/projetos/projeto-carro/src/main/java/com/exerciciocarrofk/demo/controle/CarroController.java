package com.exerciciocarrofk.demo.controle;

import com.exerciciocarrofk.demo.entidade.Carro;
import com.exerciciocarrofk.demo.repositorio.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @PostMapping
    public ResponseEntity postCarro(@RequestBody @Valid Carro novoCarro) {
        repository.save(novoCarro);
        return status(201).build();
    }
}
