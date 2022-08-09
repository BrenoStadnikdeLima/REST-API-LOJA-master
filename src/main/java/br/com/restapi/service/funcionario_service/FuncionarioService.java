package br.com.restapi.service.funcionario_service;

import br.com.restapi.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public Funcionario createFuncionario(Funcionario newFuncionario);

    public List<Funcionario> findAllFuncionarios();

    public void deleteFuncionario(Long id);

    public Funcionario updateFuncionario(Long id, Funcionario updatadFuncionario);

}
