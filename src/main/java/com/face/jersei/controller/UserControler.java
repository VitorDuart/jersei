package com.face.jersei.controller;

import com.face.jersei.data.UserDAO;
import com.face.jersei.model.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vitor
 */
@Path("/user")
public class UserControler {    
    private UserDAO dao;
    
    public UserControler(){
        this.dao = new UserDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User>getUsers() {
        List<User> users = this.dao.getUsers();
        
        return users;
    }
    
    @GET
    @Path("/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public User login(
            @PathParam("login") String login,
            @PathParam("senha") String senha    
        ){
        
        User user = this.dao.getUser(login);
        
        if(user != null){
            if(!user.getSenha().equals(senha))
                user = null;
        }
       

        return user;
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newUser(User u){
        this.dao.userStore(u);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser(User u){
        
    }
    
}
