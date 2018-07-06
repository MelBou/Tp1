package com.tp1;

import com.tp1.DB.ConnectToDB;
import com.tp1.management.Catalog;
import com.tp1.management.Basket;
import com.tp1.management.UserManagement;
import com.tp1.users.User;

import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        ConnectToDB.getInstance();



        UserManagement userManagement = new UserManagement();
        Basket basket = new Basket();
        userManagement.loadUsers();

        Scanner sc = new Scanner(System.in);
        User userConnecte = UserManagement.connectUser(sc,userManagement.loadUsers());

        Catalog catalog = new Catalog();


        if(userConnecte!=null) {
            do {
                userConnecte.menu(catalog, userManagement, basket);
            } while (userConnecte != null);
        }

    }


}
