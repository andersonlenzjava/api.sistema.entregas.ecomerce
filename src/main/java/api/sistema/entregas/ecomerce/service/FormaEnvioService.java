package api.sistema.entregas.ecomerce.service;

import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvio;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvioRegister;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvioRepository;
import api.sistema.entregas.ecomerce.domain.formaEnvio.FormaEnvioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class FormaEnvioService {

    @Autowired
    private FormaEnvioService formaEnvioService;
    @Autowired
    private FormaEnvioRepository formaEnvioRepository;

    public Page<FormaEnvioResponse> listarFormaEnvio(Pageable paginacao) {
        Page<FormaEnvio> formaEnvios = formaEnvioRepository.findAll(paginacao);
        return FormaEnvioResponse.converter(formaEnvios);
    }

    public ResponseEntity<FormaEnvioResponse> buscarFormaEnvio(Long id) {
        Optional<FormaEnvio> formaEnvioOptional = formaEnvioRepository.findById(id);
        if (formaEnvioOptional.isPresent()) {
            return ResponseEntity.ok(FormaEnvioResponse.converterUmFormaEnvio(formaEnvioOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<FormaEnvioResponse> cadastrarFormaEnvio(
            FormaEnvioRegister formaEnvioRegister, UriComponentsBuilder uriBuilder) throws Exception {

        FormaEnvio formaEnvio = formaEnvioRegister.converter();
        formaEnvioRepository.save(formaEnvio);

        URI uri = uriBuilder.path("/formaEnvio/{id}").buildAndExpand(formaEnvio.getId()).toUri();
        return ResponseEntity.created(uri).body(new FormaEnvioResponse(formaEnvio));
    }

    public ResponseEntity<FormaEnvioResponse> atualizarFormaEnvio(Long id, FormaEnvioRegister formaEnvioRegister) {
        Optional<FormaEnvio> formaEnvioOptional = formaEnvioRepository.findById(id);
        if (formaEnvioOptional.isPresent()) {
            FormaEnvio formaEnvio = formaEnvioOptional.get();

            formaEnvio.setDistancia(formaEnvioRegister.distancia());
            formaEnvio.setNome(formaEnvioRegister.nome());
            formaEnvio.setValorBase(formaEnvioRegister.valorBase());

            formaEnvioRepository.save(formaEnvio);

            return ResponseEntity.ok(new FormaEnvioResponse(formaEnvio));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletarFormaEnvio(Long id) {
        Optional<FormaEnvio> formaEnvioOptional = formaEnvioRepository.findById(id);
        if (formaEnvioOptional.isPresent()) {
            formaEnvioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
