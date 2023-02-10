package api.sistema.entregas.ecomerce.domain.formaEnvio;

import java.math.BigDecimal;

public record FormaEnvioResponse(

        long id,
        String nome,
        Double distancia,
        BigDecimal valorBase

) {
}
