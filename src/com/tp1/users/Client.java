package com.tp1.users;

import com.tp1.management.Basket;
import com.tp1.management.Catalog;
import com.tp1.management.UserManagement;
import com.tp1.products.Product;

import java.util.Scanner;
import java.util.TreeMap;

public class Client extends User {

    public Client(String firstname, String name, String town, String login, String password){

        super(firstname, name, town, login, password);
    }


    @Override
    protected void showMenu() {
        super.showMenu();
        System.out.println("4 --- Ajouter un produit au panier");
        System.out.println("5 --- Supprimer un produit du panier");
        System.out.println("6 --- Afficher le contenu du panier");
        System.out.println("-------------------------------------------------");
    }



    @Override
    protected boolean handleAction(Scanner sc, int answer, Catalog catalog, UserManagement userManagement, Basket basket) {
        if (super.handleAction(sc, answer, catalog, userManagement, basket)) {
            return true;
        }
        switch (answer){
            case 4:
                addProductToBasket(sc, catalog, basket);
                return true;
            case 5:
                deleteProductFromBasket(sc, catalog, basket);
            case 6:
                System.out.println("Contenu de votre panier :");
                basket.displayBasketContent();
                return true;
        }
        return false;
    }



    private void deleteProductFromBasket(Scanner sc, Catalog catalog, Basket basket) {
        int indexProductToDeleteFromBasket;

        TreeMap<Integer, Product> orderedProducts = basket.listBasketContent();

        basket.displayOrderedProducts(orderedProducts);
        System.out.println("Indiquez l'index du produit que vous souhaitez supprimer :");
        indexProductToDeleteFromBasket = sc.nextInt();

        Product productToDelete = orderedProducts.get(indexProductToDeleteFromBasket);
        basket.removeProductFromBasket(productToDelete);
        System.out.println("Ce produit a bien été supprimé!");
    }



    private void addProductToBasket(Scanner sc, Catalog catalog, Basket basket) {
        System.out.println("1 --- Ajouter un fruit");
        System.out.println("2 --- Ajouter un légume");
        String choiceToAdd = sc.next();
        if (choiceToAdd.equals("1")) {
            this.addFruitToBasket(sc, catalog, basket);
        } else {
            if (choiceToAdd.equals("2")) {
                this.addVeggieToBasket(sc, catalog, basket);
            } else {
                System.out.println("Choix non valide");
            }
        }
    }

    public void addFruitToBasket(Scanner sc, Catalog catalog, Basket basket){
        int whichFruitToAddToBasket;
        catalog.getFruits();
        System.out.println("Indiquez le numéro du fruit que vous souhaitez ajouter à votre panier :");
        whichFruitToAddToBasket = sc.nextInt();
        Product fruitGotBack = catalog.getOneFruit(whichFruitToAddToBasket);
        System.out.println(fruitGotBack);
        System.out.println("Indiquez la quantité souhaitée :");
        Integer quantity = sc.nextInt();
        basket.addToBasket(fruitGotBack, quantity);

        System.out.println("Fruit ajouté au panier : " + fruitGotBack.getLabel() + "\tQuantité : "+quantity);


    }

    public void addVeggieToBasket(Scanner sc, Catalog catalog, Basket basket){
        int whichVeggieToAddToBasket;
        catalog.getVeggies();
        System.out.println("Indiquez le numéro du légume que vous souhaitez ajouter à votre panier :");
        whichVeggieToAddToBasket = sc.nextInt();
        Product veggieGotBack = catalog.getOneVeggie(whichVeggieToAddToBasket);
        System.out.println(veggieGotBack);
        System.out.println("Indiquez la quantité souhaitée :");
        Integer quantity = sc.nextInt();
        basket.addToBasket(veggieGotBack, quantity);

        System.out.println("Légume ajouté au panier : " + veggieGotBack.getLabel() + "\tQuantité : "+quantity);
    }
}
