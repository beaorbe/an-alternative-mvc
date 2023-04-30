package com.rioja.wineCellar.service.implementation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.repository.Repository;
import com.rioja.wineCellar.service.service;



@Service
public class serviceimplementation implements service  {

    @Autowired
    private Repository repository;

    @Override
    public Usuario createUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    @Override
    public Iterable<Usuario> getUsuarios(){
        return repository.findAll();
    }


    @Override
    public void deleteUsuarios(){
        repository.deleteAll();
    }
    

    @Override
    public void deleteUsuario(Integer id){
        repository.deleteById(id);
    }
    

    @Override
    public Optional<Usuario> getUsuario(Usuario usuario) {

        Integer id = usuario.getID();
        return repository.findById(id);
        
    }

    @Override
    public void deleteUsuarioPorName(String username){
        repository.deleteUsuario(username);
    }
    

}
