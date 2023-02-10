package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvioRegister;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvioResponse;
import api.sistema.entregas.ecomerce.service.FormaEnvioService;
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
@RequestMapping("/formaEnvio")
public class FormaEnvioController {

    @Autowired
    private FormaEnvioService formaEnvioService;

    @GetMapping
    public Page<FormaEnvioResponse> listarFormaEnvio(
           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return formaEnvioService.listarFormaEnvio(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaEnvioResponse> buscarFormaEnvio(@PathVariable Long id) {
        return formaEnvioService.buscarFormaEnvio(id);
    }

    @PostMapping
    public ResponseEntity<FormaEnvioResponse> cadastrarFormaEnvio(
            @RequestBody @Valid FormaEnvioRegister formaEnvioRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return formaEnvioService.cadastrarFormaEnvio(formaEnvioRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormaEnvioResponse> atualizarFormaEnvio(
            @PathVariable Long id, @RequestBody @Valid FormaEnvioRegister formaEnvioRegister) {
        return formaEnvioService.atualizarFormaEnvio(id, formaEnvioRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarFormaEnvio(@PathVariable Long id) {
        return formaEnvioService.deletarFormaEnvio(id);
    }

}
