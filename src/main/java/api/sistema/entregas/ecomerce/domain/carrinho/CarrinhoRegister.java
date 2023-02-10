package api.sistema.entregas.ecomerce.domain.carrinho;

import api.sistema.entregas.ecomerce.domain.usuario.UsuarioRegister;
import jakarta.validation.Valid;


public record CarrinhoRegister(

        @Valid
        UsuarioRegister usuarioRegister

) {
}
