import java.util.Scanner;

public class Commercial extends User {


    public Commercial() {
        super();
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
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog) {
        super.handleAction(sc, answer, catalog);
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


    public void modifyProductFruit(Scanner sc, Catalog catalog) {
        int whichFruitToModify;

        System.out.println("Indiquez le numéro du produit(fruit) que vous souhaitez modifier");
        whichFruitToModify = sc.nextInt();
        catalog.getOneFruit(whichFruitToModify);
        System.out.println(catalog.getOneFruit(whichFruitToModify));

        System.out.println("Fruit choisi pour modif : " + catalog.getOneFruit(whichFruitToModify));
        System.out.println("Indiquez le nouveau nom :");
        String replacement = sc.next();
        catalog.renameFruit(replacement, whichFruitToModify);

    }

    public void modifyProductVeggie(Scanner sc, Catalog catalog) {
        int whichVeggieToModify;

        System.out.println("Indiquez le numéro du produit (légume) que vous souhaitez modifier");
        whichVeggieToModify = sc.nextInt();
        catalog.getOneVeggie(whichVeggieToModify);
        System.out.println(catalog.getOneVeggie(whichVeggieToModify));

        System.out.println("Légume choisi pour modif : " + catalog.getOneVeggie(whichVeggieToModify));
        System.out.println("Indiquez le nouveau nom :");
        String replacement = sc.next();
        catalog.renameVeggie(replacement, whichVeggieToModify);

    }

    public void addNewProductFruit(Scanner sc, Catalog catalog){

        String addNewFruit;

        System.out.println("Indiquez le nom du fruit à ajouter au catalogue :");
        addNewFruit = sc.next();
        System.out.println("Nouveau fruit ajouté : "+catalog.addFruit(addNewFruit));

    }

    public void addNewProductVeggie(Scanner sc, Catalog catalog){

        String addNewVeggie;

        System.out.println("Indiquez le nom du légume à ajouter au catalogue :");
        addNewVeggie = sc.next();
        System.out.println("Nouveau légume ajouté : "+catalog.addVeggie(addNewVeggie));

    }

    public void deleteProductFruit(Scanner sc, Catalog catalog){

        String nameFruitToDelete;

        System.out.println("Indiquez le nom du fruit que vous souhaitez supprimer :");
        nameFruitToDelete = sc.next();
        catalog.removeFruit(nameFruitToDelete);
        System.out.println("Ce fruit a bien été supprimé!");
    }

    public void deleteProductVeggie(Scanner sc, Catalog catalog){
        String nameVeggieToDelete;

        System.out.println("Indiquez le nom du légume que vous souhaitez supprimer :");
        nameVeggieToDelete = sc.next();
        catalog.removeVeggie(nameVeggieToDelete);
        System.out.println("Ce légume a bien été supprimé!");
    }


}


