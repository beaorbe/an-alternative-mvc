package com.rioja.wineCellar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("USERS")
public class Usuario {
    @Id
    @Column("ID")
    private Integer id;

    @Column("FIRST_NAME")
    private String username;

    @Column("LAST_NAME")
    private String lastname;

    @Column("EMAIL")
    private String email;

    @Column("TELEFONO")
    private String phone;

    public void setID(Integer id){
        this.id =id;
    }
    public Integer getID() {
        return id;
    }

    // Add getters and setters for all fields
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Usuario(String username, String lastname, String email,String phone )
    {
        this.username=username;
        this.lastname =lastname;
        this.email=email;
        this.phone = phone; 
    }
}

