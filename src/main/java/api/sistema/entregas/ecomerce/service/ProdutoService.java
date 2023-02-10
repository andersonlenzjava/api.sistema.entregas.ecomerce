package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.domain.pedido.Pedido;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoRegister;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoRepository;
import api.sistema.entregas.ecomerce.domain.pedido.PedidoResponse;
import api.sistema.entregas.ecomerce.domain.produto.Produto;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoRegister;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoRepository;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<ProdutoResponse> listarProduto(Pageable paginacao) {
        Page<Produto> produtos = produtoRepository.findAll(paginacao);
        return ProdutoResponse.converter(produtos);
    }

    public ResponseEntity<ProdutoResponse> buscarProduto(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.ok(ProdutoResponse.converterUmProduto(produtoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProdutoResponse> cadastrarProduto(
            ProdutoRegister produtoRegister, UriComponentsBuilder uriBuilder) throws Exception {


    }

    public ResponseEntity<ProdutoResponse> atualizarProduto(Long id, ProdutoRegister produtoRegister) {


    }

    public ResponseEntity<?> deletarProduto(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
