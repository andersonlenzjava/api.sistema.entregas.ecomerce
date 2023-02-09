package api.sistema.entregas.ecomerce.domain.formaEnvio;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FormaEnvioRegister(
        @NotBlank
        String nome,
        @NotNull
        @Digits(integer=4, fraction=0)
        double distancia,

        @DecimalMin(value = "0.1", inclusive = true)
        @Digits(integer=3, fraction=2)
        BigDecimal valorBase


) {
}
