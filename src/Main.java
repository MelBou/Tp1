import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /**
         * Demande d'infos personnelles
         */


        User user1 = new User();

        Scanner sc = new Scanner(System.in);

        System.out.println("Bonjour, quel est votre prénom?");
        user1.setFirstname(sc.nextLine());
        System.out.println("Quel est votre nom?");
        user1.setName(sc.nextLine());
        System.out.println("Où vivez-vous?");
        user1.setTown(sc.nextLine());
        System.out.println("Enchanté " + user1.getFirstname() + " " + user1.getName() + " de " + user1.getTown());
        System.out.println(" ");



        Menu menu = new Menu();
        Catalog list = new Catalog();

        /**
         * Le switch le plus long de toute l'histoire de l'humanité.
         */
        char reponse = ' ';
        String answer;
        do {
            menu.menu();
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Enchanté " + user1.getFirstname() + " " + user1.getName() + " de " + user1.getTown());
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
                            user1.setFirstname(rep1.nextLine());
                            System.out.println("Votre nouveau prénom est " + user1.getFirstname());
                            break;
                        case "2":
                            System.out.println("Indiquez votre nouveau nom");
                            Scanner rep2 = new Scanner(System.in);
                            user1.setName(rep2.nextLine());
                            System.out.println("Votre nouveau nom est " + user1.getName());
                            break;
                        case "3":
                            System.out.println("Indiquez votre nouvelle ville");
                            Scanner rep3 = new Scanner(System.in);
                            user1.setTown(rep3.nextLine());
                            System.out.println("Votre nouvelle ville est " + user1.getTown());
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
                    System.out.println("Voulez-vous quitter? O/N");
                    reponse = sc.nextLine().charAt(0);
                    break;
                default:
                    System.out.println("Je n'ai pas compris votre réponse veuillez entrer une donnée valide.");
                    System.out.println(" ");
            }

        } while(reponse != 'O');
        System.out.println("A bientôt!");

    }
}
