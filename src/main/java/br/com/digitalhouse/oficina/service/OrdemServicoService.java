package br.com.digitalhouse.oficina.service;

import br.com.digitalhouse.oficina.model.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoService {
    OrdemServico create(OrdemServico ordemServico);

    Optional<OrdemServico> find(Long id);

    List<OrdemServico> findAll();

    OrdemServico update(OrdemServico ordemServico);

    void delete(OrdemServico ordemServico);
}
