package br.com.digitalhouse.oficina.service.impl;

import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.repository.ClienteRespository;
import br.com.digitalhouse.oficina.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRespository clienteRespository;

    @Autowired
    public ClienteServiceImpl(ClienteRespository clienteRespository) {
        this.clienteRespository = clienteRespository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRespository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRespository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRespository.findById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRespository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteRespository.delete(cliente);
    }
}
