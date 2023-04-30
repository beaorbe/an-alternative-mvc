package com.rioja.wineCellar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.service.service;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private service userService;

    private Usuario user;

    @BeforeEach
    public void setUp() {
        user = new Usuario("Beatriz", "Ordonez", "bea@example.com", "600664563");
        user.setID(1);
    }

    
    //CAMINO FELIZ
    @Test
    public void addUser() throws Exception {
        String commentJson = "{\"username\":\"Beatriz\",\"lastname\":\"Ordonez\",\"email\":\"bea@example.com\",\"phone\":\"600664563\"}";
        given(userService.createUsuario(any(Usuario.class))).willReturn(user);

        mockMvc.perform(post("/Usuarios/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(commentJson))
                     .andExpect(status().isOk());
    }
                
    //CAMINO NO FELIZ
    @Test
    public void addUserError() throws Exception {
        given(userService.createUsuario(any(Usuario.class))).willThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(post("/Usuarios/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"Beatriz\",\"lastname\":\"Ordonez\",\"email\":\"bea@example.com\",\"phone\":\"600664563\"}"))
                .andExpect(status().isInternalServerError());
    }
}


