package api.sistema.entregas.ecomerce.domain.produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRegister(

        @NotBlank
        String nome,

        @DecimalMin(value = "0.1", inclusive = true)
        @Digits(integer=3, fraction=2)
        BigDecimal valorUnitario,

        @NotNull
        @Digits(integer=4, fraction=0)
        double peso


) {
}
