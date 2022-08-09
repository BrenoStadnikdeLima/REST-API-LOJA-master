package br.com.restapi.repository;

import br.com.restapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepo extends JpaRepository<Endereco, Long> {
}
