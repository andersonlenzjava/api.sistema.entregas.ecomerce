package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.domain.produto.Produto;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoRegister;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoRepository;
import api.sistema.entregas.ecomerce.domain.produto.ProdutoResponse;
import api.sistema.entregas.ecomerce.domain.usuario.Usuario;
import api.sistema.entregas.ecomerce.domain.usuario.UsuarioRegister;
import api.sistema.entregas.ecomerce.domain.usuario.UsuarioRepository;
import api.sistema.entregas.ecomerce.domain.usuario.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<UsuarioResponse> listarUsuario(Pageable paginacao) {
        Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
        return UsuarioResponse.converter(usuarios);
    }

    public ResponseEntity<UsuarioResponse> buscarUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(UsuarioResponse.converterUmUsuario(usuarioOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UsuarioResponse> cadastrarUsuario(
            UsuarioRegister usuarioRegister, UriComponentsBuilder uriBuilder) throws Exception {


    }

    public ResponseEntity<UsuarioResponse> atualizarUsuario(Long id, UsuarioRegister usuarioRegister) {


    }

    public ResponseEntity<?> deletarUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
