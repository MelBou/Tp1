package com.tp1.products;

public class Veggie extends Product{

    public Veggie(Integer id, String label, String origin){
        super(id, label, origin);

    }

    @Override
    public String toString() {
        return "---" + id +
                "\tNom : " + label +
                ", \tOrigine : " + origin;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
