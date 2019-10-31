package com.face.jersei.controller;

import com.face.jersei.data.PostDAO;
import com.face.jersei.data.UserDAO;
import com.face.jersei.model.Post;
import com.face.jersei.model.User;
import com.face.jersei.response.PostResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vitor
 */
@Path("/post")
public class PostController {
    private PostDAO dao;
    private UserDAO daoUser;
    public PostController(){
        this.dao = new PostDAO();
        this.daoUser = new UserDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostResponse> getPosts(){
        List<Post> posts = this.dao.listAll();

        List<PostResponse> response = new ArrayList();
        for(Post post : posts){
            PostResponse r = new PostResponse();
            r.setDescricao(post.getDescricao());
            r.setUser(post.getUser().getLogin());
            response.add(r);
        }
        
        return response;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newPost(Post p){
        String l = p.getUser().getLogin();
        User u = this.daoUser.getUser(l);
        p.setUser(u);
        this.dao.store(p);
    }
}
