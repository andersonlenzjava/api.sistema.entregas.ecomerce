package api.sistema.entregas.ecomerce.domain.pedido;

import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvio;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PedidoRegister(

        @NotBlank
        @Valid
        Carrinho carrinho,

        @NotBlank
        @Valid
        FormaEnvio formaEnvio

) {
}
