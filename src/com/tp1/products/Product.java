package com.tp1.products;

public abstract class Product {

    protected String label;
    protected String origin;
    protected int id;

    /**
     * Super class : products
     * Getters and setters
     * @param id
     * @param label
     * @param origin
     */
    public Product(Integer id, String label, String origin){
        this.id = id;
        this.label = label;
        this.origin = origin;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
