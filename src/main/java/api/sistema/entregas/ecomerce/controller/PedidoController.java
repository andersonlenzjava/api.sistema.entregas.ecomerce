package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.pedido.PedidoRegister;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoResponse;
import api.sistema.entregas.ecomerce.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public Page<PedidoResponse> listarPedido(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return pedidoService.listarPedido(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> cadastrarPedido(
            @RequestBody @Valid PedidoRegister pedidoRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return pedidoService.cadastrarPedido(pedidoRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoResponse> atualizarPedido(
            @PathVariable Long id, @RequestBody @Valid PedidoRegister pedidoRegister) {
        return pedidoService.atualizarPedido(id, pedidoRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPedido(@PathVariable Long id) {
        return pedidoService.deletarPedido(id);
    }

}
