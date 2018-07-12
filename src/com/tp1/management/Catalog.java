package com.tp1.management;

import com.tp1.DB.ConnectToDB;
import com.tp1.DB.FruitDAO;
import com.tp1.DB.VeggieDAO;
import com.tp1.products.Product;
import java.util.ArrayList;

/**
 * Handle all products (display the products list, rename/remove/add products)
 */
public class Catalog {
    private ArrayList<Product> fruits;
    private ArrayList<Product> veggies;
    FruitDAO fruitDAO = new FruitDAO(ConnectToDB.getInstance());
    VeggieDAO veggieDAO = new VeggieDAO(ConnectToDB.getInstance());

    public Catalog(){
//        listFruits();
  //      veggiesList();
    }

    /**
     * List of fruits : DB Tp1 (table : FruitDAO)
     */
    private void listFruits() {

        fruits = new ArrayList<>();

        fruits = fruitDAO.loadListOfFruits();

    }


    /**
     * List of veggies : DB Tp1 (table : VeggieDAO)
     */
    private void veggiesList() {
        veggies = new ArrayList<>();

        veggies = veggieDAO.loadListOfVeggies();
    }

    public void getFruits() {
        for(Product p : fruitDAO.loadListOfFruits() ){
            System.out.println(p);
        }
    }



    public void getVeggies() {
        for (Product p : veggieDAO.loadListOfVeggies()) {
            System.out.println(p);
        }
    }

    public Product getOneFruit(int id) {

        Product result = null;

        try {
            result = fruitDAO.loadListOfFruits().get(id-1);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 1 et " + fruitDAO.loadListOfFruits().size());
        }
        return result;
    }



    public Product getOneVeggie(int id){
        Product result = null;

        try {
            result = veggieDAO.loadListOfVeggies().get(id-1);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 1 et " + veggieDAO.loadListOfVeggies().size());
        }
        return result;
    }

    public void renameFruit(Product newName, int index){

        fruitDAO.modifyFruitFromDB(index, newName);
    }

    public void renameVeggie(Product newName, int index){

        veggieDAO.modifyVeggieFromDB(index, newName);
    }

    public Product addFruit(Product newFruit){
        fruitDAO.addFruitToDB(newFruit);
        return newFruit;
    }

    public Product addVeggie(Product newVeggie){
        veggieDAO.addVeggieToDB(newVeggie);
        return newVeggie;
    }

    public void removeFruit(Product fruitToDelete){
        fruitDAO.deleteFruitFromDB(fruitToDelete);
    }

    public void removeVeggie(Product veggieToDelete){

        veggieDAO.deleteVeggieFromDB(veggieToDelete);
    }



}
