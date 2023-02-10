package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.controller.CarrinhoController;
import api.sistema.entregas.ecomerce.domain.carrinho.Carrinho;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoRegister;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoRepository;
import api.sistema.entregas.ecomerce.domain.carrinho.CarrinhoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoController carrinhoController;
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Page<CarrinhoResponse> listarCarrinho(Pageable paginacao) {
        Page<Carrinho> carrinhos = carrinhoRepository.findAll(paginacao);
        return CarrinhoResponse.converter(carrinhos);
    }

    public ResponseEntity<CarrinhoResponse> buscarCarrinho(Long id) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isPresent()) {
            return ResponseEntity.ok(CarrinhoResponse.converterUmCarrinho(carrinhoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CarrinhoResponse> cadastrarCarrinho(
            CarrinhoRegister carrinhoRegister, UriComponentsBuilder uriBuilder) throws Exception {


    }

    public ResponseEntity<CarrinhoResponse> atualizarCarrinho(Long id, CarrinhoRegister carrinhoRegister) {


    }

    public ResponseEntity<?> deletarCarrinho(Long id) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isPresent()) {
            carrinhoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
