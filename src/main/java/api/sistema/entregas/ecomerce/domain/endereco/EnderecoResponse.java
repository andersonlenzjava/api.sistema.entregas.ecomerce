package api.sistema.entregas.ecomerce.domain.endereco;

public record EnderecoResponse(
        long id,
        String cep,
        String rua,
        Long numero,
        String referencia

) {
}
