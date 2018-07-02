package com.tp1.management;

import com.tp1.products.Product;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private HashMap<Product, Integer> basket;

    public Basket(){
        basketContent();
    }

    public void basketContent(){

        basket = new HashMap<>();

    }

    public void displayBasketContent(){
            int index = 0;
            for (Map.Entry<Product, Integer> e : basket.entrySet()) {
                Product key = e.getKey();
                Integer value = e.getValue();
                System.out.println(index + "\tProduit : " + key.getLabel() + "\t Quantité : " + value);
                index++;
            }
    }

    public void displayOrderedProducts(TreeMap<Integer, Product> orderedProducts){
        for (Map.Entry<Integer, Product> e : orderedProducts.entrySet()) {
            Integer key = e.getKey();
            Product value = e.getValue();
            System.out.println("\tIndex : " + key + "\t Nom Produit : " + value);
        }
    }


    public Product addToBasket(Product newItemToBasket, Integer quantity){
        this.basket.put(newItemToBasket, quantity);
        return newItemToBasket;
    }

    public void removeProductFromBasket(Product productToDelete) {
        this.basket.remove(productToDelete);
    }

    public TreeMap<Integer, Product> listBasketContent() {
        TreeMap<Integer, Product> content = new TreeMap<>();
        int index=0;
        for (Product product : basket.keySet()){
            content.put(index, product);
            index++;
        }
        return content;
    }
}
