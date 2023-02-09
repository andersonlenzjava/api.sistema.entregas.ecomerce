package api.sistema.entregas.ecomerce.domain.usuario;

import api.sistema.entregas.ecomerce.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    @OneToMany
    private Endereco endereco;

}
