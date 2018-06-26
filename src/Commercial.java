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
                this.modifyProductFruit(sc, catalog);
                break;


        }
        return false;
    }


    public void modifyProductFruit(Scanner sc, Catalog catalog){
        int whichFruitToModify;

        System.out.println("Indiquez le numéro du produit(fruit) que vous souhaitez modifier");
        whichFruitToModify = sc.nextInt();
        catalog.getOneFruit(whichFruitToModify);
        System.out.println(catalog.getOneFruit(whichFruitToModify));

        System.out.println("Fruit choisi pour modif : "+catalog.getOneFruit(whichFruitToModify));
        System.out.println("Indiquez le nouveau nom :");
        String replacement=sc.next();
        catalog.renameFruit(replacement, whichFruitToModify);

//    public void addProductFruit(Scanner sc){
//
//        }
    }
}
