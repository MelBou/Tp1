public class Admin extends User {

    boolean superModo;

    public Admin(){

        super();
    }

    @Override
    public void menu() {
        super.menu();
        System.out.println("4 --- Créer un utilisateur");
        System.out.println("5 --- Supprimer un utilisateur");
        System.out.println("-------------------------------------------------");
    }
}
