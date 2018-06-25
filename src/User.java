import java.util.Scanner;

public class User {

    private String firstname;
    private String name;
    private String town;
    private String login;
    private String password;

    public String getFirstname(){

        return firstname;
    }

    public void setFirstname(String firstname){

        this.firstname=firstname;
    }

    public String getName(){

        return name;
    }

    public void setName(String name){

        this.name=name;
    }

    public String getTown(){

        return town;
    }

    public void setTown(String town){

        this.town=town;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){

        this.password=password;
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        this.showMenu();
        int answer = readInput(sc);
        handleAction(sc, answer);
    }

    protected void showMenu(  ) {
        System.out.println("-------------------------------------------------");
        System.out.println("Maintenant, que voulez-vous faire?");
        System.out.println(" ");
        System.out.println("0 --- Quitter");
        System.out.println("1 --- Consulter vos infos personnelles");
        System.out.println("2 --- Modifier vos infos personnelles");
        System.out.println("3 --- Afficher les produits de notre catalogue");
    }

    protected boolean handleAction(Scanner sc, int answer) {
        String loginDeMerde;

        char reponse = ' ';
        Catalog list = new Catalog();
        switch (answer) {
            case 0:
                System.out.println("Voulez-vous quitter? O/N");
                reponse = sc.nextLine().charAt(0);
                return true;
            case 1:
                System.out.println("Vos données personnelles : ");
                System.out.println(this.getFirstname() + " " + this.getName() + " de " + this.getTown());
                return true;
            case 2:
                System.out.println("Indiquez vos nouvelles données personnelles : ");
                System.out.println("Nouveau login :");
                loginDeMerde = sc.nextLine();
                this.setLogin(loginDeMerde);
                System.out.println("Nouveau login : " + this.getLogin());
//                    System.out.println("Nouveau mot de passe :");
//                    userConnecte.setPassword(mdpDeMerde);
                return true;


            case 3:
                System.out.println("Voulez-vous consulter notre stock de fruits (1) ou de légumes (2)?");
                String repCase3;
                repCase3 = sc.nextLine();

                if (repCase3.equals("1")) {
                    System.out.println("Voici notre liste de fruits :");
                    list.getFruits();
                } else if (repCase3.equals("2")) {
                    System.out.println("Voici notre liste de fruits :");
                    list.getVeggies();
                } else {
                    System.out.println("Votre demande ne correspond pas à nos attentes.");
                }
                return true;
            default:
                System.out.println("Je n'ai pas compris votre réponse veuillez entrer une donnée valide.");
                System.out.println(" ");
        }
        return false;
    }

    protected int readInput(Scanner sc) {
        int answer = sc.nextInt();
        sc.nextLine();
        return answer;
    }

}