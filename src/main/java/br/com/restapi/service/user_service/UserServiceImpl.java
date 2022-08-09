package br.com.restapi.service.user_service;

import br.com.restapi.model.Usuario;
import br.com.restapi.repository.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UsuarioService{

    private final UsuarioRepo usuarioRepo;

    public UserServiceImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario createUsuario(Usuario newUser) {
        try{
            Usuario user_data = usuarioRepo.findUsuarioByUsername(newUser.getUsername());
            if(user_data != null){
                throw new IllegalArgumentException("O usuario já existe");
            }
            usuarioRepo.save(newUser);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu pau na criação do usuario");
        }
        return newUser;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void deleleUsuario(Long deletedId) {
        try{
            Optional<Usuario> user_data = usuarioRepo.findById(deletedId);

            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Este user não existe");
            }
            usuarioRepo.delete(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim no deletação do usuario");
        }
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        try{
            Optional<Usuario> user_data = usuarioRepo.findById(id);
            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Este usuario não existe");
            }

            user_data.get().setUsername(updatedUsuario.getUsername());
            user_data.get().setEmail(updatedUsuario.getEmail());
            user_data.get().setPassword(updatedUsuario.getPassword());
            user_data.get().setEndereco(updatedUsuario.getEndereco());
            user_data.get().setLoja(updatedUsuario.getLoja());



            return usuarioRepo.save(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Deu ruim no update do usuario");
        }
    }
}
