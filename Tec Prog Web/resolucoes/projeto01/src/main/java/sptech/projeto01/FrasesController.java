package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
A anotação @RestController possibilita que a classe
tenha CHAMADAS para a REST API
Ou seja, transforma a classe numa REST Controller
 */
@RestController
public class FrasesController {

    /*
A anotação @GetMapping transforma um método numa chamada da API
O que estiver dentro dos parênteses dela é a URI da chamada
     */
    @GetMapping("/cumprimentar") // URI: /cumprimentar
    public String cumprimentar() {
        return "Minha primeira API <3";
    }

/*
OBS: A convenção pra valores de URI é kebab-case
     (tudo minúsculo separado por hífem "-")
 */
    @GetMapping("/boa-noite")
    public String boaNoite() {
        return "Boa noite, durma com os anjos!";
    }

/*
Chamada /sorteio-loko que retorna a frase "Número sorteado: X"
onde X é um número inteiro aleatório entre 1 e 99
 */
    @GetMapping("/sorteio-loko")
    public String sortear() {
        int sorteado = ThreadLocalRandom.current().nextInt(1, 100);
        return String.format("Número sorteado: %d", sorteado);
    }

}
