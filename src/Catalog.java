import java.util.ArrayList;

public class Catalog {
    private ArrayList<Product> fruits;
    private ArrayList<Product> veggies;


    public Catalog(){
        listFruits();
        veggiesList();
    }


    private void listFruits() {

        fruits = new ArrayList<>();
        fruits.add(new Fruit("Abricot", "France"));
        fruits.add(new Fruit("Ananas", "France"));
        fruits.add(new Fruit("Bananes", "France"));
        fruits.add(new Fruit("Citrons", "France"));
        fruits.add(new Fruit("Fruits de la passion", "France"));
        fruits.add(new Fruit("Grenades", "France"));
        fruits.add(new Fruit("Kiwis", "France"));
        fruits.add(new Fruit("Poires", "France"));
        fruits.add(new Fruit("Pommes", "France"));

    }

    private void veggiesList() {
        veggies = new ArrayList<>();
        veggies.add(new Veggie("Artichauts", "France"));
        veggies.add(new Veggie("Asperges", "France"));
        veggies.add(new Veggie("Aubergine", "France"));
        veggies.add(new Veggie("Celeris", "France"));
        veggies.add(new Veggie("Choux", "France"));
        veggies.add(new Veggie("Courges", "France"));
        veggies.add(new Veggie("Haricots", "France"));
        veggies.add(new Veggie("Laitues", "France"));
        veggies.add(new Veggie("Radis", "France"));
        veggies.add(new Veggie("Artichauts", "France"));
    }

    public void getFruits() {
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i+" --- "+fruits.get(i));
        }
    }



    public void getVeggies() {
        for (int i = 0; i < veggies.size(); i++) {
            System.out.println(i+" --- "+veggies.get(i));
        }
    }

    public Product getOneFruit(int index) {

        Product result = null;

        try {
            result = fruits.get(index);
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + fruits.size());
        }
        return result;
    }



    public Product getOneVeggie(int index){
        Veggie result = null;

        try {
            result = (Veggie)veggies.get(index);
        } catch (ArrayIndexOutOfBoundsException i) {
            System.out.println("Choix non valide. Veuillez choisir un chiffre entre 0 et " + veggies.size());
        }
        return result;
    }

    public void renameFruit(Fruit newName, int index){

        fruits.set(index, newName);
    }

    public void renameVeggie(Veggie newName, int index){

        veggies.set(index, newName);
    }

    public Fruit addFruit(Fruit newFruit){
        this.fruits.add(newFruit);
        return newFruit;
    }

    public Veggie addVeggie(Veggie newVeggie){
        this.veggies.add(newVeggie);
        return newVeggie;
    }

    public void removeFruit(Fruit fruitToDelete){

        this.fruits.remove(fruitToDelete);
    }

    public void removeVeggie(int veggieToDelete){

        this.veggies.remove(veggieToDelete);
    }



}
