import java.util.ArrayList;
import java.util.HashMap;
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

    public void menu(Catalog catalog){
        Scanner sc = new Scanner(System.in);
        this.showMenu();
        int answer = readInput(sc);
        boolean status = handleAction(sc, answer, catalog);
        if (!status){
            System.out.println("Je n'ai pas compris votre réponse veuillez entrer une donnée valide.");
            System.out.println(" ");
        }
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

    protected boolean handleAction(Scanner sc, int answer, Catalog catalog) {
        String loginDeMerde;
        String mdpDeMerde;

        char reponse = ' ';
            switch (answer) {
                case 0:
                    System.out.println("Voulez-vous quitter? O/N");
                    reponse = sc.nextLine().charAt(0);
                    if (reponse == 'O'){
                        System.out.println("A bientôt");
                        System.exit(0);
                    }
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
                    System.out.println("Nouveau mot de passe :");
                    mdpDeMerde = sc.nextLine();
                    this.setPassword(mdpDeMerde);
                    System.out.println("Nouveau mot de passe : " + this.getPassword());
                    return true;


                case 3:
                    System.out.println("Voulez-vous consulter notre stock de fruits (1) ou de légumes (2)?");
                    String repCase3;
                    repCase3 = sc.nextLine();

                    if (repCase3.equals("1")) {
                        System.out.println("Voici notre liste de fruits :");
                        catalog.getFruits();
                    } else if (repCase3.equals("2")) {
                        System.out.println("Voici notre liste de fruits :");
                        catalog.getVeggies();
                    } else {
                        System.out.println("Votre demande ne correspond pas à nos attentes.");
                    }
                    return true;
            }
            return false;
    }

    protected int readInput(Scanner sc) {
        int answer = sc.nextInt();
        sc.nextLine();
        return answer;
    }

    public HashMap<String, User> loadUsers() {
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