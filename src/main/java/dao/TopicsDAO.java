package dao;

import classes.Topic;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by jakub on 14.06.2017.
 */
public class TopicsDAO {
    EntityManager em;

    public TopicsDAO(EntityManager em) {
        this.em = em;
    }

    public List<Topic> selectTopics()
    {
        List<Topic> topics = this.em.createQuery("select t from Topic t").getResultList();
        return topics;
    }

    public Topic selectTopicById(int id)
    {
        this.em.clear();
        return this.em.find(Topic.class, id);
    }

    public boolean insertTopic(Topic topic)
    {
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.persist(topic);
            em.flush();
            et.commit();
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }
}
