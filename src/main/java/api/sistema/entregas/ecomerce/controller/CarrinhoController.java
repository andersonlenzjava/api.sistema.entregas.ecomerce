package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoRegister;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoResponse;
import api.sistema.entregas.ecomerce.service.CarrinhoService;
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
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public Page<CarrinhoResponse> listarCarrinho(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return carrinhoService.listarCarrinho(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponse> buscarCarrinho(@PathVariable Long id) {
        return carrinhoService.buscarCarrinho(id);
    }

    @PostMapping
    public ResponseEntity<CarrinhoResponse> cadastrarCarrinho(
            @RequestBody @Valid CarrinhoRegister carrinhoRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return carrinhoService.cadastrarCarrinho(carrinhoRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CarrinhoResponse> atualizarCarrinho(
            @PathVariable Long id, @RequestBody @Valid CarrinhoRegister carrinhoRegister) {
        return carrinhoService.atualizarCarrinho(id, carrinhoRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarCarrinho(@PathVariable Long id) {
        return carrinhoService.deletarCarrinho(id);
    }


}
