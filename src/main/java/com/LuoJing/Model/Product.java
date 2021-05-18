package com.LuoJing.Model;

import java.io.InputStream;

public class Product {
    private Integer ProductId;
    private Integer CategoryID;
    private String ProductName;
    private String ProductDescription;
    private InputStream Picture;
    private double Price;



    public Product(Integer productId, Integer categoryID, String productName, String productDescription, InputStream picture, double price) {
        ProductId = productId;
        CategoryID = categoryID;
        ProductName = productName;
        ProductDescription = productDescription;
        Picture = picture;
        Price = price;
    }

    public Product(Integer categoryID, String productName, double price) {
        CategoryID = categoryID;
        ProductName = productName;
        Price = price;
    }

    public Product() {
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public InputStream getPicture() {
        return Picture;
    }

    public void setPicture(InputStream picture) {
        Picture = picture;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", CategoryID=" + CategoryID +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", Picture='" + Picture + '\'' +
                ", Price=" + Price +
                '}';
    }
}
