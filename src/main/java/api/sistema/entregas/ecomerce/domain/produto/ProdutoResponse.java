package api.sistema.entregas.ecomerce.domain.produto;

import java.math.BigDecimal;

public record ProdutoResponse(

        long id,
        String nome,
        BigDecimal valorUnitario,
        Double peso

) {
}
