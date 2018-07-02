package com.tp1.products;

public class Product {

    protected String label;
    protected String origin;

    public Product(String label, String origin){
        this.label = label;
        this.origin = origin;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
