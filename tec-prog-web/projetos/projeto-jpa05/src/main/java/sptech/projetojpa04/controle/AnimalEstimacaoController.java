package sptech.projetojpa04.controle;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa04.entidade.AnimalEstimacao;
import sptech.projetojpa04.repositorio.AnimalEstimacaoRepository;
import sptech.projetojpa04.resposta.AnimalSimplesResposta;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/pets")
public class AnimalEstimacaoController {

    @Autowired
    private AnimalEstimacaoRepository repository;

    @PostMapping
    public ResponseEntity postPet(
            @RequestBody @Valid AnimalEstimacao novoPet) {
        repository.save(novoPet);
        return status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalEstimacao>> getPets() {
        return status(200).body(repository.findAll());
    }

    @ApiResponses({
        @ApiResponse(responseCode = "200",
                     content = @Content(mediaType = "text/csv"))
    })
    @GetMapping("/relatorio")
    public ResponseEntity getRelatorio() {
        List<AnimalEstimacao> lista = repository.findAll();
        String relatorio = "";
        for (AnimalEstimacao pet : lista) {
            relatorio += pet.getCodigo()+","+pet.getNome()+"\n";
        }
        return status(200)
                    .header("content-type", "text/csv")
                    .header("content-disposition", "filename=\"relatorio-de-pets.csv\"")
                    .body(relatorio);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AnimalEstimacao> getPet(@PathVariable long codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePet(@PathVariable long codigo) {
        repository.deleteById(codigo);
        return status(200).build();
    }

    @GetMapping("/filtro/{nome}")
    public ResponseEntity<List<AnimalEstimacao>> filtro(
            @PathVariable String nome
    ) {
        return status(200).body(repository.findByNome(nome));
    }

    @GetMapping("/filtro/{nome}/{castrado}")
    public ResponseEntity<List<AnimalEstimacao>> filtro(
            @PathVariable String nome,
            @PathVariable boolean castrado
    ) {
        return status(200)
                .body(repository.findByNomeAndCastrado(nome, castrado));
    }

    @GetMapping("/tipo/{codigo}")
    public ResponseEntity<List<AnimalEstimacao>> getTipo(@PathVariable @Valid Integer codigo){
        return status(200).body(repository.findByTipoCodigo(codigo));
    }

    @GetMapping("/tipo-descricao/{descricao}")
    public ResponseEntity<List<AnimalEstimacao>> getDesc(@PathVariable @Valid String descricao){
        return status(200).body(repository.findByTipoDescricaoContains(descricao));
    }

    @GetMapping("/simples/{nome}")
    public ResponseEntity getPorNome(@PathVariable @Valid String nome){
        List<AnimalSimplesResposta> lista = repository.consultaSimplesPorNome("%"+nome+"%");
        if(lista.isEmpty()){
            return status(204).build();
        }
        return status(200).body(lista);
    }
}
