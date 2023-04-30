package com.rioja.wineCellar.service;
import java.util.Optional;
import com.rioja.wineCellar.model.Usuario;

public interface service {

    Iterable<Usuario> getUsuarios();
    Optional<Usuario> getUsuario(Usuario usuario);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Integer id);
    void deleteUsuarioPorName(String username);
    void deleteUsuarios();
}
