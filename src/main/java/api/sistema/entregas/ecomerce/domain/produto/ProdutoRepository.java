package api.sistema.entregas.ecomerce.domain.produto;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
