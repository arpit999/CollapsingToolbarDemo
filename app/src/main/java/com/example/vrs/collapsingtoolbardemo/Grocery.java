package com.example.vrs.collapsingtoolbardemo;

public class Grocery {

    String name;
    int id;

    String deliveryTime;
    String product;
    String Store;


    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    public Grocery(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Grocery(String Store, String deliveryTime, String product) {
        this.Store = Store;
        this.deliveryTime = deliveryTime;
        this.product= product;
    }

}
