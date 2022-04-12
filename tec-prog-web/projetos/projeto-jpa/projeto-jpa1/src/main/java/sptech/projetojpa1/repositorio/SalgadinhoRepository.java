package sptech.projetojpa1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sptech.projetojpa1.entidade.Salgadinho;
import sptech.projetojpa1.resposta.SalgadinhoSimplesResposta;

import java.util.List;

public interface SalgadinhoRepository extends JpaRepository<Salgadinho, Integer> {

    /*Nela escrevemos instruções na linguagem - JPQL
    A JPQL parece a Sql porém é orientada a obejtos, ou seja,
    usamos os nomes de classes e atributos aqui
    E também usas contrutores
    */
    @Query("select new sptech.projetojpa1.resposta.SalgadinhoSimplesResposta(s.codigo, s.nome) from Salgadinho s")
    List<SalgadinhoSimplesResposta> listaSimples();

    @Transactional //do pacote org.spring...
    @Modifying // do mesmo pacote
    @Query("update Salgadinho s set s.preco = ?2 where s.codigo =?1")
    void atualizarPreco(Integer codigo, Double novoPreco);
}
