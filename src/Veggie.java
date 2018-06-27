public class Veggie extends Product{
    @Override
    public String toString() {
        return "Veggie{" +
                "label='" + label + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public Veggie(String label, String origin){
        super(label, origin);

    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}