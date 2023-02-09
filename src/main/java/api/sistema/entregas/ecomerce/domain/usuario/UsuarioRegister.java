package api.sistema.entregas.ecomerce.domain.usuario;

import api.sistema.entregas.ecomerce.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRegister(

        String nome,
        String cpf,
        @Valid
        @NotBlank
        Endereco endereco

) {
}
