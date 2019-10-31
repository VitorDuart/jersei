package com.face.jersei.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vitor
 */

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    @ManyToOne
    private User user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
