import java.util.Scanner;
public class Commercial extends User {

    public Commercial(String firstname, String name, String town, String login, String password){

        super(firstname, name, town, login, password);
    }

    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("4 --- Ajouter un produit");
        System.out.println("5 --- Modifier un produit");
        System.out.println("6 --- Supprimer un produit");
        System.out.println("-------------------------------------------------");
    }
    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog, UserManagement userManagement) {
        super.handleAction(sc, answer, catalog, userManagement);
        if (!super.handleAction(sc, answer, catalog, userManagement))
        switch (answer){
            case 4:
                addProduct(sc, catalog);
                return true;
            case 5:
                modifyProduct(sc, catalog);
                return true;
            case 6:
                deleteProduct(sc, catalog);
                return true;
        }
        return false;
    }

    private void addProduct(Scanner sc, Catalog catalog) {
        System.out.println("1 --- Ajouter un fruit");
        System.out.println("2 --- Ajouter un légume");
        String choiceToAdd = sc.next();
        if (choiceToAdd.equals("1")) {
            this.addNewProductFruit(sc, catalog);
        } else {
            if (choiceToAdd.equals("2")) {
                this.addNewProductVeggie(sc, catalog);
            } else {
                System.out.println("Choix non valide");
            }
        }
    }

    private void modifyProduct(Scanner sc, Catalog catalog) {
        System.out.println("1 --- Modifier un fruit");
        System.out.println("2 --- Modifier un légume");
        String choiceToModify = sc.next();
        if (choiceToModify.equals("1")) {
            this.modifyProductFruit(sc, catalog);
        } else {
            if (choiceToModify.equals("2")) {
                this.modifyProductVeggie(sc, catalog);
            } else {
                System.out.println("Choix non valide");
            }
        }
    }

    private void deleteProduct(Scanner sc, Catalog catalog) {
        System.out.println("1 --- Supprimer un fruit");
        System.out.println("2 --- Supprimer un légume");
        String choiceToDelete = sc.next();
        if (choiceToDelete.equals("1")) {
            this.deleteProductFruit(sc, catalog);
        } else {
            if (choiceToDelete.equals("2")) {
                this.deleteProductVeggie(sc, catalog);
            } else {
                System.out.println("Choix non valide");
            }
        }
    }

    public void addNewProductFruit(Scanner sc, Catalog catalog){
        String addLabelFruit;
        String addOriginFruit;
        System.out.println("Indiquez le nom du fruit à ajouter au catalogue :");
        addLabelFruit = sc.next();
        System.out.println("Indiquez l'origine du fruit à ajouter au catalogue :");
        addOriginFruit = sc.next();
        Fruit newFruit = new Fruit(addLabelFruit, addOriginFruit);
        System.out.println("Nouveau fruit ajouté : "+catalog.addFruit(newFruit));
    }
    public void addNewProductVeggie(Scanner sc, Catalog catalog){
        String addLabelVeggie;
        String addOriginVeggie;
        System.out.println("Indiquez le nom du légume à ajouter au catalogue :");
        addLabelVeggie = sc.next();
        System.out.println("Indiquez l'origine du légume à ajouter au catalogue :");
        addOriginVeggie = sc.next();
        Veggie newVeggie = new Veggie(addLabelVeggie, addOriginVeggie);
        System.out.println("Nouveau légume ajout? : "+catalog.addVeggie(newVeggie));
    }

    public void modifyProductFruit(Scanner sc, Catalog catalog) {
        int whichFruitToModify;
        System.out.println("Indiquez le numéro du produit(fruit) que vous souhaitez modifier");
        whichFruitToModify = sc.nextInt();
        Product fruitGotBack = catalog.getOneFruit(whichFruitToModify);
        System.out.println(fruitGotBack);
        System.out.println("Fruit choisi pour modif : " + fruitGotBack);
        System.out.println("Indiquez le nouveau nom :");
        String replacement = sc.next();
        fruitGotBack.setLabel(replacement);
        catalog.renameFruit(fruitGotBack, whichFruitToModify);
    }
    public void modifyProductVeggie(Scanner sc, Catalog catalog) {
        int whichVeggieToModify;
        System.out.println("Indiquez le numéro du produit (légume) que vous souhaitez modifier");
        whichVeggieToModify = sc.nextInt();
        Product veggieGotBack = catalog.getOneVeggie(whichVeggieToModify);
        System.out.println(veggieGotBack);
        System.out.println("Légume choisi pour modif : " + veggieGotBack);
        System.out.println("Indiquez le nouveau nom :");
        String replacement = sc.next();
        veggieGotBack.setLabel(replacement);
        catalog.renameVeggie(veggieGotBack, whichVeggieToModify);
    }

    public void deleteProductFruit(Scanner sc, Catalog catalog){
        int indexFruitToDelete;
        System.out.println("Indiquez le nom du fruit que vous souhaitez supprimer :");
        indexFruitToDelete = sc.nextInt();
        Product fruitToDelete = catalog.getOneFruit(indexFruitToDelete);
        catalog.removeFruit(fruitToDelete);
        System.out.println("Ce fruit a bien été supprimé!");
    }

    public void deleteProductVeggie(Scanner sc, Catalog catalog){

        System.out.println("Indiquez le numéro du légume que vous souhaitez supprimer :");
        int userInput = sc.nextInt();
        Product dlVeggie = catalog.getOneVeggie(userInput);
        System.out.println(dlVeggie.toString());
        catalog.removeVeggie(userInput);
        System.out.println("Légume supprimé!");
    }
}