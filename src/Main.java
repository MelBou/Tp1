import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){



        UserManagement userManagement = new UserManagement();

        userManagement.loadUsers();

        Scanner sc = new Scanner(System.in);
        User userConnecte = UserManagement.connectUser(sc,userManagement.loadUsers());

        Catalog catalog = new Catalog();

        if(userConnecte!=null) {
            do {
                userConnecte.menu(catalog, userManagement);
            } while (userConnecte != null);
        }

    }


}
