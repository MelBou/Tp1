import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Catalog {
    //private String[] fruits = {"Abricots", "Ananas", "Bananes", "Citrons", "Fruits de la passion", "Grenades", "Kiwis", "Poires", "Pommes"};
    //private String[] veggies = {"Artichauts", "Asperges", "Aubergine", "Celeris", "Choux", "Courges", "Haricots", "Laitues", "Radis"};
    ArrayList<String> fruits = new ArrayList<String>();
    ArrayList<String> veggies = new ArrayList<String>();

    public void fruitsCatalog(){
        fruits.add("Abricots");
        fruits.add("Ananas");
        fruits.add("Bananes");
        fruits.add("Citrons");
        fruits.add("Fruits de la passion");
        fruits.add("Grenades");
        fruits.add("Kiwis");
        fruits.add("Poires");
        fruits.add("Pommes");
    }

    public void veggiesCatalog(){
        veggies.add("Artichauts");
        veggies.add("Asperges");
        veggies.add("Aubergine");
        veggies.add("Celeris");
        veggies.add("Choux");
        veggies.add("Courges");
        veggies.add("Haricots");
        veggies.add("Laitues");
        veggies.add("Radis");
        veggies.add("Artichauts");
    }

    public void getFruits() {
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }



    public void getVeggies() {
        for (int i = 0; i < veggies.size(); i++) {
            System.out.println(veggies.get(i));
        }
    }

    public String getOneFruit(int index) {

        String result = null;
        int tabLength = fruits.size();

        try {
            result = fruits.get(index);
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + tabLength);
        }
        return result;
    }

    public String getOneVeggie(int index){
        String result = null;

        try {
            result = veggies.get(index);
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + veggies.size());
        }
        return result;
    }





}
