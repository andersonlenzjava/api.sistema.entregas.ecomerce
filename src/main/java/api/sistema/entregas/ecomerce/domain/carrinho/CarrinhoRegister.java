package api.sistema.entregas.ecomerce.domain.carrinho;

import api.sistema.entregas.ecomerce.domain.cliente.Cliente;
import jakarta.validation.Valid;


public record CarrinhoRegister(

        @Valid
        Cliente cliente

) {
}
