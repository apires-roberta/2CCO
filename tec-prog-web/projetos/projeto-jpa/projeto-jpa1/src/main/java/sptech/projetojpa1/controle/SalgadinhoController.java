package sptech.projetojpa1.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa1.entidade.Salgadinho;
import sptech.projetojpa1.repositorio.SalgadinhoRepository;
import sptech.projetojpa1.resposta.SalgadinhoSimplesResposta;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

    @Autowired // passa reposabilidade ao spring boot iniciar a classe
    private SalgadinhoRepository repository;

    @PostMapping
    public ResponseEntity postSalgadinho(@RequestBody Salgadinho novoSalgadinho) {
        repository.save(novoSalgadinho); // insert
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getSalgadinho() {
        List<Salgadinho> salgadinhos = repository.findAll(); // select * from
        if (salgadinhos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(salgadinhos);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deleteSalgadinho(@PathVariable int codigo) {
        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @GetMapping("/{codigo}")
//    public ResponseEntity pegarSalgadinho(@PathVariable int codigo){
//        if(repository.existsById(codigo)){
//            repository.findById(codigo);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }


//Optional tem a função de previnir nullPointer

//    @GetMapping("/{codigo}")
//    public ResponseEntity pegarSalgadinho(@PathVariable int codigo){
//
//    Optional<Salgadinho> salgadinhoOptional = repository.findById(codigo);
//        if(salgadinhoOptional.isPresent()){
//            Salgadinho salgadinho = salgadinhoOptional.get();
//            return ResponseEntity.status(200).body(salgadinho);
//        }
//        return ResponseEntity.status(404).build();
//    }

    @GetMapping("/{codigo}")
    public ResponseEntity pegarSalgadinho(@PathVariable Integer codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity attSalgadinho(@PathVariable Integer codigo,
                                        @RequestBody Salgadinho salgadinho) {
        if(repository.existsById(codigo)){
            salgadinho.setCodigo(codigo);
            repository.save(salgadinho);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/contagem")
    public ResponseEntity getCOntagem(){
        long contagem = repository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples(){
        List<SalgadinhoSimplesResposta> lista = repository.listaSimples();
        //ignorando a situação de lista vazia
        return ResponseEntity.status(200).body(lista);
    }

    @PatchMapping("/{codigo}/preco/{novoPreco}")
    public ResponseEntity patchSalagadinho(
            @PathVariable Integer codigo,
            @PathVariable Double novoPreco){
        if(repository.existsById(codigo)) {
            repository.atualizarPreco(codigo, novoPreco);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


}
