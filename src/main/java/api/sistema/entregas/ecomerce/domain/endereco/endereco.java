package api.sistema.entregas.ecomerce.domain.endereco;

import jakarta.persistence.*;

@Entity
public class endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cep;
    private String rua;
    private Long numero;
    private String referencia;



}
