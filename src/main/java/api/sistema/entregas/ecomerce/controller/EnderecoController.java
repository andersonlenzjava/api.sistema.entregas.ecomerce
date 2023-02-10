package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.endereco.EnderecoRegister;
import api.sistema.entregas.ecomerce.domain.endereco.EnderecoResponse;
import api.sistema.entregas.ecomerce.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public Page<EnderecoResponse> listarEnderecos(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return enderecoService.listarEnderecos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> buscarEnderecos(@PathVariable Long id) {
        return enderecoService.buscarEnderecos(id);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastrarEndereco(
            @RequestBody @Valid EnderecoRegister enderecoRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return enderecoService.cadastrarEndereco(enderecoRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoResponse> atualizarEndereco(
            @PathVariable Long id, @RequestBody @Valid EnderecoRegister enderecoRegister) {
        return enderecoService.atualizarEndereco(id, enderecoRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
        return enderecoService.deletarEndereco(id);
    }

}
