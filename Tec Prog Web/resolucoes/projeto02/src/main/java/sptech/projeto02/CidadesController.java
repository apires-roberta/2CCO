package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@RequestMapping indica qual o prefixo padrão de todas as chamadas
na classe
No caso, todas as chamadas serão iniciadas com "/cidades"
 */
@RestController
@RequestMapping("/cidades")
public class CidadesController {

    @GetMapping("/listar") // URI: /cidades/listar
    public String listar() {
        return "todas as cidades";
    }

    @GetMapping("/top-5") // URI: /cidades/top-5
    public String top5() {
        return "As top 5 são A, B e C";
    }

    @GetMapping // URI: /cidades
    public String home() {
        return "Bem vindos à API de cidades";
    }
}
