package sptech.projetojpa01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import java.util.List;

public interface SalgadinhoRepository
            extends JpaRepository<Salgadinho, Integer> {
/*
A @Query aceita instruções na linguagem JPQL (Java Persistence Query Language)
A diferença é que nela devemos usar os nomes das Entidades e não tabelas
 */
    @Query("select new sptech.projetojpa01.resposta.SalgadinhoSimplesResposta(s.codigo, s.nome) from Salgadinho s")
    List<SalgadinhoSimplesResposta> listaSimples();

    List<Salgadinho> findByApimentadoTrue();

    List<Salgadinho> findByApimentadoFalse();

    @Query("select s from Salgadinho s where s.nivelSal < 4")
    List<Salgadinho> poucoSal();

    @Query("select s from Salgadinho s where s.preco <= 20")
    List<Salgadinho> caros();

    @Query("select s from Salgadinho s where s.preco between ?1 and ?2")
    List<Salgadinho> valorEntreSalgadinhos(double preco1, double preco2);

    @Query("select s from Salgadiho s where s.nome = ?1")
    List<Salgadinho> pegaNome(String nome);

}
