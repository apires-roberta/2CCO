package com.sptech.projeto2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class OlimpiadasController {

    List<Pais> listPaises = new ArrayList<>();

    @GetMapping
    public Pais teste() {
        Pais pais = new Pais("Brasil", 2, 4, 5);
        return pais;
    }

    @GetMapping("/listar")
    public List<Pais> listaPaises() {
        listPaises.add(new Pais("Brazil", 1, 3, 6));
        listPaises.add(new Pais("Japão", 3, 3, 6));
        return listPaises;
    }

    @GetMapping("/cadstrar/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastrarPais(
            @PathVariable String nome,
            @PathVariable int ouro,
            @PathVariable int prata,
            @PathVariable int bronze
            ){
        listPaises.add(new Pais(nome, ouro, prata, bronze));
        return "Pais cadastrado com sucesso!";
    }

    //buscar/{indice}

    @GetMapping("/buscar/{indice}")
    public Pais busca(@PathVariable int indice){
        return listPaises.get(indice);

    }
}
