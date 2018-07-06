package com.tp1.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    private static String url = "jdbc:mariadb://localhost:3306";
    private static String user = "root";
    private static String passwd = "happysmile26000";
    private static Connection connect;

    private ConnectToDB(){
        try {
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static Connection getInstance(){
        if(connect == null){
            new ConnectToDB();
    }
        return connect;
    }

}
