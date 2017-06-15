package dao;

import classes.Inscription;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by jakub on 14.06.2017.
 */
public class InscriptionsDAO {
    EntityManager em;

    public InscriptionsDAO(EntityManager em) {
        this.em = em;
    }

    public List<Inscription> selectInscription()
    {
        List<Inscription> inscriptions = this.em.createQuery("select i from Inscription i").getResultList();
        return inscriptions;
    }

    public Inscription selectInscriptionById(int id)
    {
        em.clear();
        Inscription inscription = em.find(Inscription.class, id);
        return inscription;
    }

    public boolean insertInscription(Inscription inscription)
    {
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.persist(inscription);
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
