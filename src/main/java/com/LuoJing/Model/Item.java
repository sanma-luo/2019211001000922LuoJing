package com.LuoJing.Model;

import java.io.Serializable;

public class Item implements Serializable {
    private Product product;
    private int quantity;

    public Item() {super();}

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(Product product, int quantity) {
        super();
        this.product = product;
        this.quantity = quantity;
    }
}
