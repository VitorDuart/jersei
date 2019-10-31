package com.face.jersei.data;

import com.face.jersei.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author vitor
 */
public class UserDAO {
    
    public List<User> getUsers(){
        String sql = "SELECT u FROM User u";
        EntityManager m = Connection.getInstance();
        Query q = m.createQuery(sql);
        List<User> users = q.getResultList();
        return users;
    }
    
    public User getUser(String login){
        User u;
        try {
            String s = "SELECT u "
                + "FROM User u "
                + "WHERE u.login = :login";
        
            TypedQuery<User> q = Connection.getInstance().createQuery(s,User.class);
            q.setParameter("login", login);
            u = q.getSingleResult(); 
        } catch (Exception e) { u = null; }
           
        return u;
    }
    
    public void userStore(User u){
        Connection.getInstance().getTransaction().begin();
        Connection.getInstance().persist(u);
        Connection.getInstance().getTransaction().commit();
    }
}
