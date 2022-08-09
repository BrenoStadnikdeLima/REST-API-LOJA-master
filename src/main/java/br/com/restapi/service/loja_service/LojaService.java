package br.com.restapi.service.loja_service;


import br.com.restapi.model.Loja;

import java.util.List;

public interface LojaService {

    public Loja createLoja(Loja newLoja);

    public List<Loja> findAllLojas();

    public void deleteLoja(Long id);

    public Loja updateLoja(Long id, Loja updatedLoja);



}
