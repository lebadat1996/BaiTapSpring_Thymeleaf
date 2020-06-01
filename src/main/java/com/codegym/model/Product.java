package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private String Category;
    private String color;

    public Product(int id, String nameProduct, String category, String color) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.Category = category;
        this.color = color;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
