package dao; /**
 * Created by jakub on 11.06.2017.
 */

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitiatorDB implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        EntityManager em = DBConfig.createEntityManager();
        UsersDAO usersDAO = new UsersDAO(em);
        TopicsDAO topicsDAO = new TopicsDAO(em);
        InscriptionsDAO inscriptionsDAO = new InscriptionsDAO(em);
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("usersDAO", usersDAO);
        servletRequest.setAttribute("topicsDAO", topicsDAO);
        servletRequest.setAttribute("inscriptionsDAO", inscriptionsDAO);
    }
}
