
public class Fruit extends Product {

    public Fruit(String label, String origin){
        super(label, origin);

    }

    public String toString() {
            return "Nom = '" + label + '\'' +
                    "; Origine = '" + origin + '\'';
        }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOrigin(String origin){
        this.origin = origin;}

}
