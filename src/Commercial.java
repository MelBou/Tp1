public class Commercial extends User {

    public Commercial() {
        super();
    }

    @Override
    public void menu() {
        super.menu();
        System.out.println("4 --- Ajouter un produit");
        System.out.println("5 --- Modifier un produit");
        System.out.println("-------------------------------------------------");
    }
}
