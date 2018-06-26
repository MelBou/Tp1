import java.util.Scanner;

public class Client extends User {

    public Client() {
        super();
    }

    @Override
    protected void showMenu() {
        super.showMenu();
        System.out.println("4 --- Ajouter un produit au panier");
        System.out.println("5 --- Afficher le contenu du panier");
        System.out.println("-------------------------------------------------");
    }



    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog) {
        if (super.handleAction(sc, answer, catalog)) {
            return true;
        }
        return false;
    }
}
