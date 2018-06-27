import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){



        UserManagement Users = new UserManagement();

        Users.loadUsers();

        Scanner sc = new Scanner(System.in);
        User userConnecte = UserManagement.connectUser(sc,Users.loadUsers());

        Catalog catalog = new Catalog();

        if(userConnecte!=null) {
            do {
                userConnecte.menu(catalog);
            } while (userConnecte != null);
        }

    }


}
