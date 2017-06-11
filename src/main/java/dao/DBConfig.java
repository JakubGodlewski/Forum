package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by jakub on 11.06.2017.
 */
public class DBConfig implements ServletContextListener{

    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
         emf=Persistence.createEntityManagerFactory("Forum");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(emf != null && emf.isOpen())
            emf.close();
    }

    public static EntityManager createEntityManager()
    {
        if(emf != null)
            return emf.createEntityManager();
        else return null;
    }
}
