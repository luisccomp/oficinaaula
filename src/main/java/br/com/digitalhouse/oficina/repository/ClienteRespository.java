package br.com.digitalhouse.oficina.repository;

import br.com.digitalhouse.oficina.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long> {

}
