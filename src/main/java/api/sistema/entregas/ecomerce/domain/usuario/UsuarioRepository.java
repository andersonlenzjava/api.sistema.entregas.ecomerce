package api.sistema.entregas.ecomerce.domain.usuario;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
