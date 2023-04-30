package com.rioja.wineCellar.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.service.service;

@RestController
//@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private service service;

    //crear usuarios
    @CrossOrigin("*")
    @PostMapping("/Usuarios/post")
    public ResponseEntity<Usuario> createPersona(@RequestBody Usuario usuario) {
       
        Usuario newUsuario = service.createUsuario(usuario);
        return ResponseEntity.ok().body(newUsuario);
    }


    //devolver todos los usuarios
    @CrossOrigin("*")
    @GetMapping("/Usuarios/getAll")
    public ResponseEntity<Iterable<Usuario>> getUsuarios(){

        Iterable<Usuario> response = service.getUsuarios();
        return ResponseEntity.ok().body(response);
    }


    //buscar 1 isuario
    @CrossOrigin("*")
    @GetMapping("/Usuarios/buscar")
    public ResponseEntity<Optional<Usuario>> getUsuario(@RequestBody Usuario usuario) {

        Integer id = usuario.getID();
        if (id!=null){
            Optional<Usuario> response = service.getUsuario(usuario);
            return ResponseEntity.ok().body(response);
        }else{
            Optional<Usuario> response = null; 
            return ResponseEntity.ok().body(response);
        }

    }

    //eliminar un usuario
    @CrossOrigin("*")
    @DeleteMapping("/Usuarios/delete/porID")
    public void deleteUsuario(@RequestBody Usuario usuario) {

        Integer id = usuario.getID();
        if (id!=null){
            service.deleteUsuario(id);
        }
    }


    @CrossOrigin("*")
    @DeleteMapping("/Usuarios/delete/nombre")
    public void deleteUsuarioPorName(@RequestBody Usuario usuario) {

        String username = usuario.getUsername();
        if (username != null){
            service.deleteUsuarioPorName(username);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping("/Usuarios/delete/todos")
    public void Eliminartodos() {
        service.deleteUsuarios();
    }

    
}

