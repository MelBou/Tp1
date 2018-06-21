import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /**
         * Création "base de données" avec 3 utilisateurs (un admin, un client, un commercial)
         */

        Scanner sc = new Scanner(System.in);

        User user1 = new Admin();
        User user2 = new Client();
        User user3 = new Commercial();

        user1.setFirstname("Jean");
        user1.setName("Bon");
        user1.setTown("Aoste");

        user2.setFirstname("Abby");
        user2.setName("Gael");
        user2.setTown("Cardiff");

        user3.setFirstname("Richard");
        user3.setName("Dassault");
        user3.setTown("Leclerc");

        user1.setLogin("123");
        user1.setPassword("456");
        user2.setLogin("456");
        user2.setPassword("456");
        user3.setLogin("789");
        user3.setPassword("789");


       Map<String, User> userList = new HashMap<>();
       userList.put("123", user1);
       userList.put("456", user2);
       userList.put("789", user3);


        /**
         * Connexion de l'utilisateur :
         * Vérification : présence du login dans la base de données.
         * Vérification : mot de passe correct.
         * Affichage du menu selon le statut de l'utilisateur (admin, client, commercial).
         */
        User userConnecte = null;
        boolean loginFailed = true;
        do {
        String loginDeMerde;
        System.out.println("Saisissez votre login");
        loginDeMerde = sc.nextLine();

        if (userList.containsKey(loginDeMerde)){
            userConnecte = userList.get(loginDeMerde);
            System.out.println("Saisissez votre mot de passe");
            String mdpDeMerde = sc.nextLine();


            if (mdpDeMerde.equals(userConnecte.getPassword())){
                loginFailed=false;
            } else {
                System.out.println("Le mot de passe n'est pas valide. Veuillez réessayer.");
            }
        } else {
            System.out.println("Cette entrée n'est pas reconnue par la base de données. Veuillez réessayer.");
        }
        } while (loginFailed);

        if(userConnecte!=null){
            userConnecte.menu();
        }


//        Menu menu = new Menu();
//        Catalog list = new Catalog();
//
//        /**
//         * Le switch le plus long de toute l'histoire de l'humanité.
//         */
//        char reponse = ' ';
//        String answer;
//        do {
//            menu.menu();
//            answer = sc.nextLine();
//            switch (answer) {
//                case "1":
//                    System.out.println("Enchanté " + user1.getFirstname() + " " + user1.getName() + " de " + user1.getTown());
//                    System.out.println(" ");
//                    System.out.println(" ");
//                    break;
//
//                case "2":
//                    System.out.println("1 --- Pour mettre a jour votre Prénom");
//                    System.out.println("2 --- Pour mettre a jour votre Nom");
//                    System.out.println("3 --- Pour mettre a jour votre Ville");
//
//                    String rep;
//                    rep = sc.nextLine();
//
//                    switch (rep){
//                        case "1":
//                            System.out.println("Indiquez votre nouveau prénom");
//                            Scanner rep1 = new Scanner(System.in);
//                            user1.setFirstname(rep1.nextLine());
//                            System.out.println("Votre nouveau prénom est " + user1.getFirstname());
//                            break;
//                        case "2":
//                            System.out.println("Indiquez votre nouveau nom");
//                            Scanner rep2 = new Scanner(System.in);
//                            user1.setName(rep2.nextLine());
//                            System.out.println("Votre nouveau nom est " + user1.getName());
//                            break;
//                        case "3":
//                            System.out.println("Indiquez votre nouvelle ville");
//                            Scanner rep3 = new Scanner(System.in);
//                            user1.setTown(rep3.nextLine());
//                            System.out.println("Votre nouvelle ville est " + user1.getTown());
//                            break;
//                        }
//                    break;
//
//                case "3":
//                    System.out.println("Voulez-vous consulter notre stock de fruits (1) ou de légumes (2)?");
//                    String repCase3;
//                    repCase3 = sc.nextLine();
//
//                    if (repCase3.equals("1")){
//                        System.out.println("Voici notre liste de fruits :");
//                        list.getFruits();
//                    } else if (repCase3.equals("2")){
//                        System.out.println("Voici notre liste de fruits :");
//                        list.getVeggies();
//                    } else {
//                        System.out.println("Votre demande ne correspond pas à nos attentes.");
//                    }
//                    break;
//                case "4":
//                    System.out.println("Voulez-vous quitter? O/N");
//                    reponse = sc.nextLine().charAt(0);
//                    break;
//                default:
//                    System.out.println("Je n'ai pas compris votre réponse veuillez entrer une donnée valide.");
//                    System.out.println(" ");
//            }
//
//        } while(reponse != 'O');
//        System.out.println("A bientôt!");

//        Catalog fruit = new Catalog();
//        fruit.getOneFruit();
//        System.out.println(fruit[5]);


//        Catalog menuF = new Catalog();
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Indiquer le numéro du fruit choisi");
//        int whichFruit = -1;
//        try {
//            whichFruit = sc.nextInt();
//        } catch(InputMismatchException i){
//            System.out.println("Merci d'indiquer un chiffre ou un nombre.");
//        }
//
//        String fruitChoisi = menuF.getOneFruit(whichFruit);
//
//        if (fruitChoisi!=null) {
//            System.out.println(fruitChoisi);
//        }
    }
}
