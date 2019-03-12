package com.company.common;

import java.io.Serializable;

public class Product implements Serializable {

    private Integer id;
    private String productName;
    private Double price;
    private String status; //SOLD, FOR_SALE

    public Product(String productName, Double price, String status) {
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
