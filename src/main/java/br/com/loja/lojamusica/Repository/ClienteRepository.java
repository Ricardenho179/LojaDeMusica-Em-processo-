package br.com.loja.lojamusica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.lojamusica.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
