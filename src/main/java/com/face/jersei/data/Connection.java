package com.face.jersei.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;

/**
 *
 * @author vitor
 */
public class Connection {
    private static EntityManagerFactory factory;
    private volatile static EntityManager manager;
    
    public static EntityManager getInstance(){
        if(manager == null){
            synchronized(Connection.class){
                if(manager == null){
                    try{
                        factory = Persistence.createEntityManagerFactory("facetruco");
                        manager = factory.createEntityManager();
                    }catch(HibernateException he){
                        System.err.println(he.getMessage());
                    }
                }
            }
        }
        return manager;
    }
    
    public static void close(){
        factory.close();
    }
}
