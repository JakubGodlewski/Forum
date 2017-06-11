package test;

import dao.DatabaseInterfaceImpl;

/**
 * Created by jakub on 11.06.2017.
 */
public class main {
    public static void main(String[] args) {
        DatabaseInterfaceImpl.getInstance().selectRole().forEach(x -> System.out.println(x));
    }
}
