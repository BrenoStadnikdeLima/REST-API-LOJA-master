package br.com.restapi.service.funcionario_service;

import br.com.restapi.model.Funcionario;
import br.com.restapi.repository.FuncionarioRepo;

import java.util.List;
import java.util.Optional;

public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepo funcionarioRepo;

    public FuncionarioServiceImpl(FuncionarioRepo funcionarioRepo) {
        this.funcionarioRepo = funcionarioRepo;
    }

    @Override
    public Funcionario createFuncionario(Funcionario newFuncionario) {

        try{
            funcionarioRepo.save(newFuncionario);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Algo de errado aconteceu na criação do funcionario tente novamente");
        }

        return newFuncionario;
    }

    @Override
    public List<Funcionario> findAllFuncionarios() {
        return funcionarioRepo.findAll();
    }

    @Override
    public void deleteFuncionario(Long id) {
        try {
            Optional<Funcionario> funcionario_data = funcionarioRepo.findById(id);
            if (funcionario_data.isEmpty()) {
                throw new IllegalArgumentException("Parece que esse mano ai não existe mermão");
            }
            funcionarioRepo.delete(funcionario_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim mano tenta ai denovo");
        }
    }

    @Override
    public Funcionario updateFuncionario(Long id, Funcionario updatadFuncionario) {
        try {
            Optional<Funcionario> funcionario_data = funcionarioRepo.findById(id);
            if (funcionario_data.isEmpty()) {
                throw new IllegalArgumentException("Parece que esse mano ai não existe mermão");
            }

            funcionario_data.get().setNome(updatadFuncionario.getNome());
            funcionario_data.get().setEmail(updatadFuncionario.getEmail());
            funcionario_data.get().setCargo(updatadFuncionario.getCargo());
            funcionario_data.get().setEndereco(updatadFuncionario.getEndereco());
            funcionario_data.get().setLoja(updatadFuncionario.getLoja());

            funcionarioRepo.save(funcionario_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim mano tenta ai denovo");
        }
        return updatadFuncionario;
    }
}
