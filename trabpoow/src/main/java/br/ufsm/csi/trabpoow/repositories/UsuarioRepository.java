package br.ufsm.csi.trabpoow.repositories;

import br.ufsm.csi.trabpoow.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByNome(String nome);
}
