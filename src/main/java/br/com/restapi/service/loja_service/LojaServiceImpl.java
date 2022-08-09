package br.com.restapi.service.loja_service;

import br.com.restapi.model.Loja;
import br.com.restapi.repository.LojaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaServiceImpl implements LojaService {

    private final LojaRepo lojaRepo;

    public LojaServiceImpl(LojaRepo lojaRepo) {
        this.lojaRepo = lojaRepo;
    }

    @Override
    public Loja createLoja(Loja newLoja) {

        try{
            lojaRepo.save(newLoja);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu pau na criação da loja");
        }
        return newLoja;
    }

    @Override
    public List<Loja> findAllLojas() {
        return lojaRepo.findAll();
    }

    @Override
    public void deleteLoja(Long id) {

        try {
            Optional<Loja> loja_data = lojaRepo.findById(id);
            if (loja_data.isEmpty()){
                throw new IllegalArgumentException("Não exista loja caramba");
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim já era");
        }

    }

    @Override
    public Loja updateLoja(Long id, Loja updatedLoja) {
        try{
            Optional<Loja> loja_data = lojaRepo.findById(id);
            if(loja_data.isEmpty()){
                throw new IllegalArgumentException("Loja Não existe parceiro");
            }
            loja_data.get().setNome(updatedLoja.getNome());
            loja_data.get().setEndereco(updatedLoja.getEndereco());
            loja_data.get().setFuncionarios_list(updatedLoja.getFuncionarios_list());
            loja_data.get().setProdutos_list(updatedLoja.getProdutos_list());
            loja_data.get().setUser_list(updatedLoja.getUser_list());

            lojaRepo.save(loja_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim parceiro lascou");
        }


        return updatedLoja;
    }
}
