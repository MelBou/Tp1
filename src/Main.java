import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /**
         * Demande d'infos personnelles
         */


        User user1 = new User();

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
        Catalog list = new Catalog();

        /**
         * Le switch le plus long de toute l'histoire de l'humanité.
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
                    System.out.println("1 --- Pour mettre a jour votre Prénom");
                    System.out.println("2 --- Pour mettre a jour votre Nom");
                    System.out.println("3 --- Pour mettre a jour votre Ville");

                    String rep;
                    rep = sc.nextLine();

                    switch (rep){
                        case "1":
                            System.out.println("Indiquez votre nouveau prénom");
                            Scanner rep1 = new Scanner(System.in);
                            user1.firstname = rep1.nextLine();
                            System.out.println("Votre nouveau prénom est " + user1.firstname);
                            break;
                        case "2":
                            System.out.println("Indiquez votre nouveau nom");
                            Scanner rep2 = new Scanner(System.in);
                            user1.name = rep2.nextLine();
                            System.out.println("Votre nouveau nom est " + user1.name);
                            break;
                        case "3":
                            System.out.println("Indiquez votre nouvelle ville");
                            Scanner rep3 = new Scanner(System.in);
                            user1.town = rep3.nextLine();
                            System.out.println("Votre nouvelle ville est " + user1.town);
                            break;
                        }
                    break;

                case "3":
                    System.out.println("Voulez-vous consulter notre stock de fruits (1) ou de légumes (2)?");
                    String repCase3;
                    repCase3 = sc.nextLine();

                    if (repCase3.equals("1")){
                        System.out.println("Voici notre liste de fruits :");
                        list.getFruits();
                    } else if (repCase3.equals("2")){
                        System.out.println("Voici notre liste de fruits :");
                        list.getVeggies();
                    } else {
                        System.out.println("Votre demande ne correspond pas à nos attentes.");
                    }
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
