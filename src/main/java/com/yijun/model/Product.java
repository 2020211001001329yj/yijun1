package com.yijun.model;


import java.sql.Blob;

public class Product {

  private long productId;
  private String productName;
  private String productDescription;
  private Blob picture;
  private double price;
  private long categoryId;

  public Product() {
  }

  public Product(long productId, String productName, String productDescription, Blob picture, double price, long categoryId) {
    this.productId = productId;
    this.productName = productName;
    this.productDescription = productDescription;
    this.picture = picture;
    this.price = price;
    this.categoryId = categoryId;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }


  public Blob getPicture() {
    return picture;
  }

  public void setPicture(Blob picture) {
    this.picture = picture;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

}
