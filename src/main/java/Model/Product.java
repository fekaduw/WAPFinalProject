package Model;

import java.io.InputStream;

public class Product {

    private int id;
    private String name;
    private double price;
    private InputStream picture;
    private String description;

    public Product(){

    }

    public Product( String name, double price, String description, InputStream picture) {
        this.name = name;
        this.price = price;
        this.description = description;
        ;

        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
