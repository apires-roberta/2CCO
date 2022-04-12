package sptech.projetojpa03.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.projetojpa03.entidade.AnimalEstimacao;

import java.util.List;

public interface AnimalEstimacaoRepository
                        extends JpaRepository<AnimalEstimacao, Long> {

    /*Aqui usamos um recurso chamado DYNAMIC FINDERS*/

    List<AnimalEstimacao> findByNome(String nome);

    List<AnimalEstimacao> findByNomeAndCastrado(String nome, boolean castrado);

    /*@Query(""slect a fromAnimalEstimacao a where a.nome = ?1)
    * List<AnimalEstimacao> filtroPorNome(String nome);
    *
    * @Query("select a from AnimalEstimacao a where a.nome = ?1 and a.cadastro = ?2")
    * List<AnimalEstimacao> filtroPorNomeECadastrado(String nome, boolean cadastro);
    * */
}
