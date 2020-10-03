package br.com.digitalhouse.oficina.service.impl;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;
import br.com.digitalhouse.oficina.service.OrdemServicoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoImpl implements OrdemServicoService {

    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoImpl(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @Override
    public OrdemServico create(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public Optional<OrdemServico> find(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public OrdemServico update(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void delete(OrdemServico ordemServico) {
        ordemServicoRepository.delete(ordemServico);
    }
}
