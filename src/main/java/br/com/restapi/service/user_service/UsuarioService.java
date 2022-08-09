package br.com.restapi.service.user_service;

import br.com.restapi.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario createUsuario(Usuario newUser);

    public List<Usuario> findAllUsuarios();

    public void deleleUsuario(Long deletedId);

    public Usuario updateUsuario(Long id, Usuario updatedUsuario);



}
