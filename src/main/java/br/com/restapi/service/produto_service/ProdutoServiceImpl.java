package br.com.restapi.service.produto_service;

import br.com.restapi.model.Produto;
import br.com.restapi.repository.ProdutoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepo produtoRepo;

    public ProdutoServiceImpl(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    @Override
    public Produto createProduto(Produto newProduto) {
        try{
            produtoRepo.save(newProduto);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu pau na criação do produto");
        }
        return newProduto;
    }

    @Override
    public List<Produto> findAllProdutos() {
        return produtoRepo.findAll();
    }

    @Override
    public void deleteProduto(Long deletedProduto) {
         try{
             Optional<Produto> produto_data = produtoRepo.findById(deletedProduto);
             if (produto_data.isEmpty()){
                 throw new IllegalArgumentException("Não existe");
             }
             produtoRepo.delete(produto_data.get());
         }
         catch (Exception e){
             throw new IllegalArgumentException("Deu pau na deletação do produto");
         }
    }

    @Override
    public Produto updateProduto(Long id, Produto updatedProduto) {
        try{
            Optional<Produto> produto_data = produtoRepo.findById(id);
            if (produto_data.isEmpty()){
                throw new IllegalArgumentException("Não existe");
            }
            produto_data.get().setNome(updatedProduto.getNome());
            produto_data.get().setPreco(updatedProduto.getPreco());
            produto_data.get().setLoja_list(updatedProduto.getLoja_list());

            produtoRepo.save(produto_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu pau na deletação do produto");
        }
        return updatedProduto;
    }
}
