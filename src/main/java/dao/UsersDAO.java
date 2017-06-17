package dao;

import classes.Role;
import classes.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jakub on 14.06.2017.
 */
public class UsersDAO {
    EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public User getUserByLogin(String login)
    {
        User user = (User)this.em.createQuery("select u from User u where u.login = :login")
                .setParameter("login", login).getSingleResult();
        return user;
    }

    public boolean insertUser(User user)
    {
        user.setPassword(this.getMD5(user.getPassword()));
        Role role = new Role();
        role.setLogin(user.getLogin());
        role.setRole("user");
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.persist(user);
            em.flush();
            em.persist(role);
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

    private String getMD5(String data)
    {
        MessageDigest md5;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
        md5.update(data.getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());
        String ready = hash.toString(16);
        if(ready.length() == 31)
            ready = "0"+ready;
        return ready;
    }
}
