import java.util.Scanner;

public class User {

    String firstname;
    String name;
    String town;



    public void updateUserInfo(){

        System.out.println("1 --- Pour mettre a jour votre Nom");
        System.out.println("2 --- Pour mettre a jour votre Prenom");
        System.out.println("3 --- Pour mettre a jour votre ville");

        Scanner sc = new Scanner(System.in);
        String rep;
        rep = sc.nextLine();

        switch (rep){



            case "1":


                System.out.println("Indiquez votre nouveau NOM");
                Scanner rep1 = new Scanner(System.in);
                firstname = rep1.nextLine();
                System.out.println("Votre nouveau NOM est " + firstname);
                break;
            case "2":
                System.out.println("Changer 2");
                break;
            case "3":
                System.out.println("Changer 3");
                break;

        }

    }

}
