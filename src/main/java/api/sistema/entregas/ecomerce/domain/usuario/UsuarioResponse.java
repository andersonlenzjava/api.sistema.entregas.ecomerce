package api.sistema.entregas.ecomerce.domain.usuario;

import api.sistema.entregas.ecomerce.domain.endereco.EnderecoResponse;

public record UsuarioResponse(
        long id,
        String nome,
        String cpf,
        EnderecoResponse enderecoResponse

) {
}
