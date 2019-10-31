/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.face.jersei.data;

import com.face.jersei.model.Post;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author vitor
 */
public class PostDAO {
    public List<Post>listAll(){
        String s = "SELECT p FROM Post p";
        TypedQuery<Post> q = Connection.getInstance().createQuery(s, Post.class);
        List<Post> posts = q.getResultList();
        return posts;
    }
    
    public void store(Post p){
        Connection.getInstance().getTransaction().begin();
        Connection.getInstance().persist(p);
        Connection.getInstance().getTransaction().commit();
    }
}
