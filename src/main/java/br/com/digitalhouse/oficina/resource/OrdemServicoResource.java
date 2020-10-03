package br.com.digitalhouse.oficina.resource;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.service.OrdemServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/ordens-servico")
@RestController
public class OrdemServicoResource {

    private OrdemServicoService ordemServicoService;

    public OrdemServicoResource(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServico) throws Exception {
        OrdemServico o = ordemServicoService.create(ordemServico);

        URI uri = new URI(String.format("/ordens-servico/%d", o.getId()));

        return ResponseEntity.created(uri)
                .body(o);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> findAll() {
        return ResponseEntity.ok(ordemServicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> find(@PathVariable Long id) {
        Optional<OrdemServico> ordemServico = ordemServicoService.find(id);

        return ordemServico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> update(@PathVariable Long id, @RequestBody OrdemServico ordemServico) {
        if (ordemServico.getId() == null) {
            return ResponseEntity.badRequest().build();
        } else if (ordemServicoService.find(ordemServico.getId()).isPresent()) {
            ordemServico.setId(id);

            return ResponseEntity.ok(ordemServicoService.update(ordemServico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<OrdemServico> ordemServico = ordemServicoService.find(id);

        if (ordemServico.isPresent()) {
            ordemServicoService.delete(ordemServico.get());

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
