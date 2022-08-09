package br.com.restapi.repository;

import br.com.restapi.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
}
