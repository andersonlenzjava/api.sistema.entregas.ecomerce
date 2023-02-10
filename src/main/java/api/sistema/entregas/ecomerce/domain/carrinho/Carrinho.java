package api.sistema.entregas.ecomerce.domain.carrinho;

import api.sistema.entregas.ecomerce.domain.produto.Produto;
import api.sistema.entregas.ecomerce.domain.usuario.Usuario;
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
    private Usuario usuario;
    @OneToOne
    private List<Produto> produtos;


}
