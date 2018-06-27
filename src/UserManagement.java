import java.util.HashMap;
import java.util.Scanner;

public class UserManagement {
    public HashMap<String, User> loadUsers() {
        User user1 = new Admin("Jean", "Bon", "Aoste", "123", "456");
        User user2 = new Client("Abby", "Gael", "Cardiff", "456", "456");
        User user3 = new Commercial("Richard", "Dassault", "Leclerc", "789", "789");
        

        HashMap<String, User> userList = new HashMap<>();
        userList.put("123", user1);
        userList.put("456", user2);
        userList.put("789", user3);
        return userList;

    }

    protected static User connectUser(Scanner sc, HashMap<String, User> userList) {
        /**
         * Connexion de l'utilisateur :
         * Vérification : présence du login dans la base de données.
         * Vérification : mot de passe correct.
         * Affichage du menu selon le statut de l'utilisateur (admin, client, commercial).
         */
        User userConnecte = null;
        String loginDeMerde;
        String mdpDeMerde;

        boolean loginFailed = true;
        do {
            System.out.println("Saisissez votre login");
            loginDeMerde = sc.nextLine();

            if (userList.containsKey(loginDeMerde)){
                userConnecte = userList.get(loginDeMerde);
                System.out.println("Saisissez votre mot de passe");
                mdpDeMerde = sc.nextLine();

                if (mdpDeMerde.equals(userConnecte.getPassword())){
                    loginFailed=false;
                } else {
                    System.out.println("Le mot de passe n'est pas valide. Veuillez réessayer.");
                }
            } else {
                System.out.println("Cette entrée n'est pas reconnue par la base de données. Veuillez réessayer.");
            }
        } while (loginFailed);
        return userConnecte;
    }
}
