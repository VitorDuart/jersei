package com.face.jersei.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author vitor
 */

@Entity
public class User implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer idade;
    private String login;
    private String senha;
    
    @Override   
    public String toString(){
        return this.name;
    }

    //Getrs and Setrs
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

 
    
}
