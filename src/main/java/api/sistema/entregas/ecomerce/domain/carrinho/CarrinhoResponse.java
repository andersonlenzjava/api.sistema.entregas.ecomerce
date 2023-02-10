package api.sistema.entregas.ecomerce.domain.carrinho;

import api.sistema.entregas.ecomerce.domain.produto.ProdutoResponse;

import java.util.List;

public record CarrinhoResponse(

        Long carrinhoId,
        Long usuarioId,
        List<ProdutoResponse> produtos

) {
}
