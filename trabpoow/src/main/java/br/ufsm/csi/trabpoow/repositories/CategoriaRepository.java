package br.ufsm.csi.trabpoow.repositories;

import br.ufsm.csi.trabpoow.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
