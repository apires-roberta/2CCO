  package com.sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pontuacao {

    int vitoria = 0;
    int derrota = 0;
    int empate = 0;
    int partidas = 0;
    int pontos = 0;

    @GetMapping("/registra-vitoria")
    public String contagem() {
        vitoria += 3;
        partidas += 1;
        return String.format("Vitorias: %d", vitoria);
    }

    @GetMapping("/registra-derrota")
    public String contagem2() {
        derrota = 0;
        partidas += 1;
        return String.format("Derrotas: %d", derrota);
    }

    @GetMapping("/registra-empate")
    public String contagem3() {
        empate += 1;
        partidas += 1;
        return String.format("Empates: %d", empate);
    }

    @GetMapping("/pontuacao")
    public String potuacao() {
        pontos = vitoria + empate;
        if(partidas < 1){
            return String.format("Você não jogou nenhuma partida");
        }else {
            Integer max = partidas * 3;
            Integer aprov = (pontos * 100) / max;
            return String.format("Ola você tem %d pontos e %d partidas - Aproveitamento: %d ", pontos, partidas, aprov);
        }
    }

    @GetMapping("/resetar")
    public String resetar() {
        pontos = 0;
        vitoria = 0;
        derrota = 0;
        empate = 0;
        partidas = 0;
        return "Jogo resetado";
    }
}
