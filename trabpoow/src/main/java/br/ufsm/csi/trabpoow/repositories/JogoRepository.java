package br.ufsm.csi.trabpoow.repositories;

import br.ufsm.csi.trabpoow.models.Jogo;
import br.ufsm.csi.trabpoow.models.RelatorioJogosAvaliados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {
    Jogo findById(int id);
    void deleteById(int id);

    @Query(value = "SELECT new br.ufsm.csi.trabpoow.models.RelatorioJogosAvaliados( j.nome, c.nome, j.avaliacao)\n" +
            "FROM Jogo j\n" +
            "JOIN Categoria c ON c.idCategoria = j.categoria.idCategoria\n" +
            "ORDER BY c.nome ASC, j.avaliacao DESC ")
    List<RelatorioJogosAvaliados> obterRelatorioJogosAvaliados();
}
