package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.controller.EnderecoController;
import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoRegister;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoRepository;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoResponse;
import api.sistema.entregas.ecomerce.domain.endereco.Endereco;
import api.sistema.entregas.ecomerce.domain.endereco.EnderecoRegister;
import api.sistema.entregas.ecomerce.domain.endereco.EnderecoRepository;
import api.sistema.entregas.ecomerce.domain.endereco.EnderecoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoController enderecoController;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Page<EnderecoResponse> listarEndereco(Pageable paginacao) {
        Page<Endereco> enderecos = enderecoRepository.findAll(paginacao);
        return EnderecoResponse.converter(enderecos);
    }

    public ResponseEntity<EnderecoResponse> buscarEndereco(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            return ResponseEntity.ok(CarrinhoResponse.converterUmEndereco(enderecoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<EnderecoResponse> cadastrarEndereco(
            EnderecoRegister enderecoRegister, UriComponentsBuilder uriBuilder) throws Exception {


    }

    public ResponseEntity<EnderecoResponse> atualizarEndereco(Long id, EnderecoRegister enderecoRegister) {


    }

    public ResponseEntity<?> deletarEndereco(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            enderecoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
