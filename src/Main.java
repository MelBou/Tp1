import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /**
         * Demande d'infos personnelles
         */


        User user1 = new User();
        User updateInfo = new User();


        Scanner sc = new Scanner(System.in);

        System.out.println("Bonjour, quel est votre prénom?");
        user1.firstname = sc.nextLine();
        System.out.println("Quel est votre nom?");
        user1.name = sc.nextLine();
        System.out.println("Où vivez-vous?");
        user1.town = sc.nextLine();
        System.out.println("Enchanté " + user1.firstname + " " + user1.name + " de " + user1.town);
        System.out.println(" ");


        /**
         * Affichage du menu
         */

        Menu menu = new Menu();
//        menu.menu();


        /**
         *
         */

        String answer;


        do {

            menu.menu();
            answer = sc.nextLine();


            switch (answer) {

                case "1":
                    System.out.println("Enchanté " + user1.firstname + " " + user1.name + " de " + user1.town);
                    System.out.println(" ");
                    System.out.println(" ");
                    break;

                case "2":
                    updateInfo.updateUserInfo();
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;

                default:
                    System.out.println("Je n'ai pas compris votre réponse veuillez vous faire foutre");
                    System.out.println(" ");

            }


        }

        while (answer != "1");


    }
}
