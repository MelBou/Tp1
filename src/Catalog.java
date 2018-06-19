public class Catalog {
    String fruits[] = {"Abricots", "Ananas", "Bananes", "Citrons", "Fruits de la passion", "Grenades", "Kiwis", "Poires", "Pommes"};
    String veggies[] = {"Artichauts", "Asperges", "Aubergine", "Celeris", "Choux", "Courges", "Haricots", "Laitues", "Radis"};

    public void getFruits(){
        for (int i=0;i<fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }

    public void getVeggies(){
        for (int i=0;i<veggies.length; i++) {
            System.out.println(veggies[i]);
        }
    }
}
