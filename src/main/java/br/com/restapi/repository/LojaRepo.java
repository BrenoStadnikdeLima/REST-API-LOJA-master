package br.com.restapi.repository;

import br.com.restapi.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepo extends JpaRepository<Loja, Long> {
}
