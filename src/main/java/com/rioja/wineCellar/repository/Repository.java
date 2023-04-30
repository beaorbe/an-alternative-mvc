package com.rioja.wineCellar.repository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.rioja.wineCellar.model.Usuario;

public interface Repository extends CrudRepository <Usuario, Integer> {

    @Query("DELETE * FROM USERS WHERE USERS.USERNAME= :usuario")
    public Void deleteUsuario(String usuario);
}

