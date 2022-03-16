package com.sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons")

public class PokemonController {

    List<Pokemon> listaPokemon = new ArrayList<>();

    @GetMapping
    public Pokemon obj(){
        Pokemon pokemon = new Pokemon();

    }

    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public void


}
