package api.sistema.entregas.ecomerce.domain.endereco;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
