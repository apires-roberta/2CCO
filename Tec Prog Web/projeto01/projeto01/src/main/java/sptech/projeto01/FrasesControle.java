package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrasesControle {
    @GetMapping
    public String cumprimentar() {
        return "Boa noite";
    }

    Double x = 0.0;

    @GetMapping("/boanoite")
    public String boanoite() {
        x = Math.random() * 10;
        return String.format("ola boa noite %.2f", x);
    }

    @GetMapping("/{numero1}/{numero2}")
    public String somar(@PathVariable int numero1, @PathVariable int numero2) {
        int soma = numero1 + numero2;
        return String.format("Resultado %d", soma);
    }

    @GetMapping("/{nome}")
    public String saudacao(@PathVariable String nome) {
        return String.format("Be vindo %s", nome);
    }

    private int numero = 0;

    @GetMapping("/contar")
    public String contar() {

        return String.format("Contando %d", numero++);
    }
}


