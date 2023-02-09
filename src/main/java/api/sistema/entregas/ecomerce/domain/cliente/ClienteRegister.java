package api.sistema.entregas.ecomerce.domain.cliente;

import api.sistema.entregas.ecomerce.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ClienteRegister(

        @Valid
        @NotBlank
        Usuario usuario
) {
}
