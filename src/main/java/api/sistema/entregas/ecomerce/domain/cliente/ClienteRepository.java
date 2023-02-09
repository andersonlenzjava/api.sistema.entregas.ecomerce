package api.sistema.entregas.ecomerce.domain.cliente;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
