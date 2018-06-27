import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){



        User Users = new User();

        Users.loadUsers();

        Scanner sc = new Scanner(System.in);
        User userConnecte = User.connectUser(sc,Users.loadUsers());

        Catalog catalog = new Catalog();

        if(userConnecte!=null) {
            do {
                userConnecte.menu(catalog);
            } while (userConnecte != null);
        }

    }


}
