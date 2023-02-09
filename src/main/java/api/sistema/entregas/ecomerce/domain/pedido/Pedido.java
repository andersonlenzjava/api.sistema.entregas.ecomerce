package api.sistema.entregas.ecomerce.domain.pedido;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Carrinho carrinho;
    @OneToOne
    private FormaEnvio formaEnvio;


}
