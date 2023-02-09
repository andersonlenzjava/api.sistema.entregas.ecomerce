package api.sistema.entregas.ecomerce.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record EnderecoRegister(

        @NotBlank
        @Length(min = 8, max = 8)
        String cep,
        @NotBlank
        String rua,
        @NotBlank
        @Positive
        Long numero,
        @NotBlank
        String referencia

) {
}
