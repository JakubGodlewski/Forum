package test;

import classes.Role;
import dao.DBConfig;
import dao.DatabaseInterfaceImpl;
import dao.RolesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        RolesDAO rolesDAO = new RolesDAO(em);
        for(Role r: rolesDAO.selectRoles())
        {
            System.out.println(r);
        }
        //System.out.println(rolesDAO.getRoleById(1));
    }
}
