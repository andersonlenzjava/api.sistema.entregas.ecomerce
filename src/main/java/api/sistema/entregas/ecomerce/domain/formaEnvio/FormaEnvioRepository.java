package api.sistema.entregas.ecomerce.domain.formaEnvio;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaEnvioRepository extends JpaRepository<FormaEnvio, Long> {
}
