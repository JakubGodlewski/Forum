package dao;

import classes.Role;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jakub on 11.06.2017.
 */
public class RolesDAO {
    EntityManager em;

    public RolesDAO(EntityManager em) {
        this.em = em;
    }

    public List<Role> selectRoles()
    {
        List<Role> roles = this.em.createQuery("select r from Role r").getResultList();
        return roles;
    }

    public Role getRoleById(int id)
    {
        Role role = this.em.find(Role.class, id);
        return role;
    }
}
