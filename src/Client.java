import java.util.Scanner;

public class Client extends User {

    public Client(String firstname, String name, String town, String login, String password){

        super(firstname, name, town, login, password);
    }

    @Override
    protected void showMenu() {
        super.showMenu();
        System.out.println("4 --- Ajouter un produit au panier");
        System.out.println("5 --- Afficher le contenu du panier");
        System.out.println("-------------------------------------------------");
    }



    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog, UserManagement userManagement) {
        if (super.handleAction(sc, answer, catalog, userManagement)) {
            return true;
        }
        return false;
    }
}
