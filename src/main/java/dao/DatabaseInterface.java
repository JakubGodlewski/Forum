package dao;

import classes.Role;

import java.util.List;

/**
 * Created by jakub on 11.06.2017.
 */
public interface DatabaseInterface {

    List<Role> selectRole();
}
