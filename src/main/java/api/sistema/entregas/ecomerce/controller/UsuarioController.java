package api.sistema.entregas.ecomerce.controller;

import api.sistema.entregas.ecomerce.domain.usuario.UsuarioRegister;
import api.sistema.entregas.ecomerce.domain.usuario.UsuarioResponse;
import api.sistema.entregas.ecomerce.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioResponse> listarUsuario(
           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {
        return usuarioService.listarUsuario(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(
            @RequestBody @Valid UsuarioRegister usuarioRegister,
            UriComponentsBuilder uriBuilder) throws Exception {
        return usuarioService.cadastrarUsuario(usuarioRegister, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioResponse> atualizarUsuario(
            @PathVariable Long id, @RequestBody @Valid UsuarioRegister usuarioRegister) {
        return usuarioService.atualizarUsuario(id, usuarioRegister);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        return usuarioService.deletarUsuario(id);
    }

}
