package sptech.projetojpa01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.repositorio.SalgadinhoRepository;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import java.util.List;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

    @Autowired
    private SalgadinhoRepository repository;

    @PostMapping
    public ResponseEntity postSalgadinho(
            @RequestBody Salgadinho novoSalgadinho) {
        repository.save(novoSalgadinho);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getSalgadinhos() {

        new SalgadinhoSimplesResposta(1, "cheetos");

        List<Salgadinho> lista = repository.findAll();

        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        List<SalgadinhoSimplesResposta> lista =
                repository.listaSimples();

        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
// .count() faz um "select count(*)" p/ saber quantos registros tem na tabela
        long contagem = repository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/apimentados")
    public ResponseEntity getApimentados() {
        List<Salgadinho> apimentado = repository.findByApimentadoTrue();
        return ResponseEntity.status(200).body(apimentado);
    }

    @GetMapping("/contagem-nao-apimentados")
    public ResponseEntity getContagemNaoApimentados() {
        long naoApimentados = repository.findByApimentadoFalse().stream().count();
        return ResponseEntity.status(200).body(naoApimentados);
    }

    @GetMapping("/pouco-sal")
    public ResponseEntity getPoucoSal() {
        List<Salgadinho> poucoSal = repository.poucoSal();
        return ResponseEntity.status(200).body(poucoSal);
    }

    @GetMapping("/caros")
    public ResponseEntity getCaros() {
        List<Salgadinho> salgadinhosCaros = repository.caros();
        return ResponseEntity.status(200).body(salgadinhosCaros);
    }

    @GetMapping("/relatorio-geral")
    public ResponseEntity getRelatorio() {
        String relatorio = "";

        List<Salgadinho> lista = repository.findAll();
        for (var salg : lista) {
            relatorio += salg.getCodigo() + "," + salg.getNome() + "," + salg.getNivelSal() + "," + salg.getPreco() + "\r\n";
        }

        return ResponseEntity
                .status(200)
                .header("content-type", "text/csv")
                //.header("content-length", "9999999999")
                .header("content-disposition", "filename=\"salgadinhos.csv\"")
                .body(relatorio);

    }

    @GetMapping("/filtro-preco/{preco1}/{preco2}")
    public ResponseEntity getListaPreco(@PathVariable double preco1, @PathVariable double preco2) {
        List<Salgadinho> getPrecoEntreSalgadinhos = repository.valorEntreSalgadinhos(preco1, preco2);
        return ResponseEntity.status(200).body(getPrecoEntreSalgadinhos);
    }

    @GetMapping("/filtro-nome/{nome}")
    public ResponseEntity getNome(@PathVariable String nome) {
        List<Salgadinho> pegarNome = repository.pegaNome(nome);
        return ResponseEntity.status(200).body(pegarNome);
    }
}

