package sptech.projeto04.controle;

import org.springframework.web.bind.annotation.*;
import sptech.projeto04.entidade.Heroi;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    @GetMapping
    public List<Heroi> getHerois() {
        return herois;
    }

    @PostMapping
    public String postHeroi(@RequestBody Heroi novoHeroi) {
        herois.add(novoHeroi);
        return "Herói cadastrado com sucesso";
    }

    @GetMapping("/{indice}")
    public String getHeroi(@PathVariable int indice) {
        if (indice>herois.size()) {
            return "Heroi nao encontrado";
        } else {
            return "Heroi encontrado" + herois.get(indice);
        }
    }

    @PutMapping("/{indice}")
    public String attHeroi(@PathVariable int indice,
                           @RequestBody Heroi heroiAtt) {
        herois.set(indice, heroiAtt);
        if (indice>herois.size()) {
            return "Heroi nao encontrado";
        } else {
            return "Heroi atualizado com sucesso";
        }
    }

    @DeleteMapping("/{indice}")
    public String delHeroi(@PathVariable int indice) {
        herois.remove(indice);
        if (indice>herois.size()) {
            return "Heroi nao encontrado";
        } else {
            return "Heroi deletado!";
        }

    }

}
