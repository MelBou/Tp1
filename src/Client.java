public class Client extends User {

    public Client() {
        super();
    }

    @Override
    public void menu() {
        super.menu();
        System.out.println("4 --- Ajouter un produit au panier");
        System.out.println("5 --- Afficher le contenu du panier");

        System.out.println("-------------------------------------------------");
    }
}
