package com.sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons")

public class PokemonController {

    List<Pokemon> listaPokemon = new ArrayList<>(List.of(
            new Pokemon("Pikachu", "elétrico", 90_000.0, false),
            new Pokemon("Bubasaur", "aquático", 22_000.0, true),
            new Pokemon("ReisFish", "aquático", 1_000.0, true)));

    @GetMapping
    public Pokemon obj() {
        Pokemon pokemon = new Pokemon();
        return pokemon;
    }

    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public String cadastrar(@PathVariable String nome,
                            @PathVariable String tipo,
                            @PathVariable Double forca,
                            @PathVariable Boolean capturado) {
        listaPokemon.add(new Pokemon(nome, tipo, forca, capturado));
        return "Pokemon " + nome + " cadastrado com sucesso";
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable int indice){
        if(indice>listaPokemon.size()){
            return "Pokemon inexistente";
        }else{
            listaPokemon.remove(indice);
            return "Pokemon " + listaPokemon.get(indice).getNome() + "removido com sucesso";
        }
    }

    @GetMapping("/buscar/{indice}")
    public Pokemon buscar(@PathVariable int indice){
        return listaPokemon.get(indice);
    }

    @GetMapping("/atualizar/{indice}/{nome}/{tipo}/{forca}/{capturado}")
    public String atualizar(@PathVariable int indice,
                            @PathVariable String nome,
                            @PathVariable String tipo,
                            @PathVariable Double forca,
                            @PathVariable Boolean capturado){
        if(indice>listaPokemon.size()){
            return "Pokemon não encontrado";
        }else{
            listaPokemon.set(indice, new Pokemon(nome, tipo, forca, capturado));
            return "Pokemon "+ listaPokemon.get(indice).getNome() +" atualizado com sucesso";
        }
    }

    @GetMapping("/listar")
    public List<Pokemon> listar(){
       return listaPokemon;
    }
}
