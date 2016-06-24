package com.example.vrs.collapsingtoolbardemo;

public class Flower {

    String name;
    int id;
    String delivery;
    String product;
    String Store;


    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flower(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
