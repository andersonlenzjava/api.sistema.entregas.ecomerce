package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.produto.ProdutoRegister;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoResponse;
import api.sistema.entregas.ecomerce.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<ProdutoResponse> listarProduto(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return produtoService.listarProduto(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable Long id) {
        return produtoService.buscarProduto(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(
            @RequestBody @Valid ProdutoRegister produtoRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return produtoService.cadastrarProduto(produtoRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoResponse> atualizarProduto(
            @PathVariable Long id, @RequestBody @Valid ProdutoRegister produtoRegister) {
        return produtoService.atualizarProduto(id, produtoRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        return produtoService.deletarProduto(id);
    }

}
