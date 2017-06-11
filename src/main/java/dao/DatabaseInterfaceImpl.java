package dao;

import classes.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 11.06.2017.
 */
public class DatabaseInterfaceImpl implements DatabaseInterface{

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_NAME = "jdbc:mysql://localhost:3306/forum";
    private final String DB_LOGIN ="root";
    private final String DB_PASSWORD ="admin";
    private Connection connection; //posluzy do zaradzania komunikacja z  baza danych
    private Statement statement; //zmienna pozwoli latwo wykoac iektore zaoytania jak np. select

    private DatabaseInterfaceImpl()
    {
        try {
            Class.forName(DRIVER); //ladujemy do aplikacji sterownik
            connection = DriverManager.getConnection(DB_NAME, DB_LOGIN, DB_PASSWORD);//polaczy sie z serwerem i utworzy bazde danych Dziekanat.db
            statement = connection.createStatement(); //zmienna stat zostala w tym momencie uprawniona do wykonywania zapytan
            //na utworzonej bazie danych
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static DatabaseInterfaceImpl databaseInterface = null;

    public static DatabaseInterfaceImpl getInstance()
    {
        if (databaseInterface == null)
        {
            databaseInterface = new DatabaseInterfaceImpl();
        }
        return databaseInterface;
    }

    public List<Role> selectRole() {

        List<Role> roles = new ArrayList<Role>();
        String query ="select * from role";
        try
        {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);

            while(rs.next())
            {
                roles.add(new Role(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return roles;
    }
}
