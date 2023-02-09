package api.sistema.entregas.ecomerce.domain.carrinho;

import api.sistema.entregas.ecomerce.domain.cliente.Cliente;
import api.sistema.entregas.ecomerce.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @OneToOne
    private List<Produto> produtos;


}
