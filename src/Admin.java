import java.util.Scanner;

public class Admin extends User {

    boolean superModo;

    public Admin(String firstname, String name, String town, String login, String password){

        super(firstname, name, town, login, password);
    }

    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("4 --- Créer un utilisateur");
        System.out.println("5 --- Modifier les informations d'un utilisateur");
        System.out.println("6 --- Supprimer un utilisateur");
        System.out.println("-------------------------------------------------");
    }

    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog) {
        super.handleAction(sc, answer, catalog);
        if (!super.handleAction(sc, answer, catalog))
            switch (answer){
                case 4:
                    //méthode addUser
                    return true;
                case 5:
                    //méthode modifyUser
                case 6:
                    //méthode deleteUser
                    return true;
            }
        return false;
    }

}
