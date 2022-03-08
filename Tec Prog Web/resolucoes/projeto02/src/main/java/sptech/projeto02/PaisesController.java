package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    private List<Pais> paises = new ArrayList<>();

    @GetMapping("/cadastrar/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastraPais(
            @PathVariable String nome,
            @PathVariable Integer ouro,
            @PathVariable Integer prata,
            @PathVariable Integer bronze
    ){

        for (Pais pais: paises) {
            if (pais.getNome().equalsIgnoreCase(nome)){
                return "Pais já cadastrado, tente novamente.";
            }
        }

        paises.add(new
                Pais(nome, ouro, prata, bronze));
        return "Pais cadastrado com sucesso.";
    }

    @GetMapping("/listar")
    public List<Pais> listar(){
        return paises;
    }

    // /buscar/{indice}
    @GetMapping("/buscar/{indice}")
    public Pais buscarPorIndice(@PathVariable Integer indice){
        if (isIndiceValido(indice)){
            return paises.get(indice);
        }
        return null;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastraPais(
            @PathVariable Integer indice,
            @PathVariable String nome,
            @PathVariable Integer ouro,
            @PathVariable Integer prata,
            @PathVariable Integer bronze
    ){

//        Maneira alternativa:
//        paises.get(indice).setNome(nome);
//        paises.get(indice).setMedalhasDeOuro(ouro);
//        paises.get(indice).setMedalhasDePrata(prata);
//        paises.get(indice).setMedalhasDeBronze(bronze);

        if(isIndiceValido(indice)){
            paises.set(indice, new Pais(nome,ouro,prata,bronze));
            return "Pais atualizado com sucesso.";
        }

        return "Pais não encontrado.";
    }

    @GetMapping("/remover/{indice}")
    public String removerPais(@PathVariable int indice){

        if (isIndiceValido(indice)){
            paises.remove(indice);
            return  "Pais removido com sucesso";
        }

        return  "Pais não encontrado";
    }

    private boolean isIndiceValido(int indice) {
        return indice >= 0 && indice < paises.size();
    }
}
