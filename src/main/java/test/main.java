package test;

import classes.Inscription;
import classes.Topic;
import dao.DBConfig;
import dao.InscriptionsDAO;
import dao.TopicsDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by jakub on 11.06.2017.
 */
public class main {
    public static void main(String[] args) {
        /*DatabaseInterfaceImpl.getInstance().selectRole().forEach(x ->System.out.println(x));
        EntityManager em = DBConfig.createEntityManager();
        RolesDAO rolesDAO = new RolesDAO(em);
        //rolesDAO.selectRoles().forEach(x ->System.out.println(x));
        System.out.println(rolesDAO.gerRoleById(1));*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = emf.createEntityManager();
        TopicsDAO dao1 = new TopicsDAO(em);
        InscriptionsDAO dao2 = new InscriptionsDAO(em);

        //List<Inscription> inscriptions = dao2.selectInscription();
        //List<Topic> topics = dao1.selectTopics();
        /*for(Topic t: topics)
        {
            System.out.println(t);
        }*/
        Topic t = dao1.selectTopicById(2);
        System.out.println(t.getTitle()+", "+t.getContent());
        //System.out.println(dao2.selectInscriptionById(1));

        /*List<Topic> topics = dao.selectTopics();
        for(Topic t: topics)
        {
            System.out.println(t);
        }*/

        /*opic t = dao.selectTopicById(1);
        System.out.println(t);*/

    }
}
