package com.tp1.products;

public abstract class Product {

    protected String label;
    protected String origin;

    /**
     * Super class : products
     * Getters and setters
     * @param label
     * @param origin
     */
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
