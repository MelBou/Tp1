import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Catalog {
    private String[] fruits = {"Abricots", "Ananas", "Bananes", "Citrons", "Fruits de la passion", "Grenades", "Kiwis", "Poires", "Pommes"};
    private String[] veggies = {"Artichauts", "Asperges", "Aubergine", "Celeris", "Choux", "Courges", "Haricots", "Laitues", "Radis"};

    public void getFruits() {
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }

    public void getVeggies() {
        for (int i = 0; i < veggies.length; i++) {
            System.out.println(veggies[i]);
        }
    }

    public String getOneFruit(int index) {

        String result = null;
        int tabLength = fruits.length;

        try {
            result = fruits[index];
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + tabLength);
        }
        return result;
    }

    public String getOneVeggie(int index){
        String result = null;

        try {
            result = veggies[index];
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + veggies.length);
        }
        return result;
    }





}
