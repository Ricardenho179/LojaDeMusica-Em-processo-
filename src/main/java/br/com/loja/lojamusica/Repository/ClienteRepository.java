package br.com.loja.lojamusica.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.loja.lojamusica.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//HQL
	@Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
	Optional<Cliente> findByCpf(@Param("cpf") String cpf);
}
