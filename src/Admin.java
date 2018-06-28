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
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog, UserManagement userManagement) {
        boolean handleActionAnswer = super.handleAction(sc, answer, catalog, userManagement);
        if (!handleActionAnswer)
            switch (answer){
                case 4:
                    addUser(sc, userManagement);
                    return true;
                case 5:
                    //méthode modifyUser
                    return true;
                case 6:
                    //méthode deleteUser
                    return true;
            } else {
            return true;
        }
        return false;
    }


    private void addUser(Scanner sc, UserManagement userManagement) {
        System.out.println("1 --- Ajouter un admin");
        System.out.println("2 --- Ajouter un client");
        System.out.println("3 --- Ajouter un commercial");
        int choiceToAdd = sc.nextInt();

        switch (choiceToAdd){
            case 1:
                this.addNewAdmin(sc, userManagement);
                break;
            case 2:
                this.addNewClient(sc, userManagement);
                break;
            case 3:
                this.addNewCommercial(sc, userManagement);
                break;
            default:
                System.out.println("Oops");
        }
    }

    public void addNewAdmin(Scanner sc, UserManagement userManagement){

    }

    public void addNewClient(Scanner sc, UserManagement userManagement){

    }

    public void addNewCommercial(Scanner sc, UserManagement userManagement){

    }




}
