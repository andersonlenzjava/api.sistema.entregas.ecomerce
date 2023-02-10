package api.sistema.entregas.ecomerce.domain.pedido;

public record PedidoResponse(

        Long pedidoId,

        Long carrinhoId,

        Long formaEnvioId

) {
}
