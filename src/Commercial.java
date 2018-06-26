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
        System.out.println("-------------------------------------------------");
    }

    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog) {
        super.handleAction(sc, answer, catalog);
        switch (answer){
            case 5:
                System.out.println("1 --- Modifier un fruit");
                System.out.println("2 --- Modifier un légume");
                String choice = sc.next();
                if (choice.equals("1")) {

                this.modifyProductFruit(sc, catalog);
                } else {
                    if (choice.equals("2")) {
                        this.modifyProductVeggie(sc, catalog);
                    } else {
                System.out.println("Choix non valide");
                }
        }
                break;


        }
        return false;
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
//    public void addProductFruit(Scanner sc){
//
//        }
    }


