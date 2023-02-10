package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.domain.pedido.Pedido;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoRegister;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoRepository;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;

    public Page<PedidoResponse> listarPedido(Pageable paginacao) {
        Page<Pedido> pedidos = pedidoRepository.findAll(paginacao);
        return PedidoResponse.converter(pedidos);
    }

    public ResponseEntity<PedidoResponse> buscarPedido(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            return ResponseEntity.ok(PedidoResponse.converterUmEndereco(pedidoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PedidoResponse> cadastrarPedido(
            PedidoRegister pedidoRegister, UriComponentsBuilder uriBuilder) throws Exception {


    }

    public ResponseEntity<PedidoResponse> atualizarPedido(Long id, PedidoRegister pedidoRegister) {


    }

    public ResponseEntity<?> deletarPedido(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
