package api.sistema.entregas.ecomerce.domain.cliente;

import api.sistema.entregas.ecomerce.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Usuario usuario;

}
