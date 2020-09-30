package br.com.digitalhouse.oficina.service;

import br.com.digitalhouse.oficina.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente create(Cliente cliente);

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente update(Cliente cliente);

    void delete(Cliente cliente);

}
