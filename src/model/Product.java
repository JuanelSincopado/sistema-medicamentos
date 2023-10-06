package model;

import java.util.Date;

public class Product {
  private int product_id;
  private String name;
  private String brand;
  private String category;
  private String subCategory;
  private int sold;
  private int stock;
  private String price;
  private String description;
  private Date creationDate;
  private Date expirationDate;

  public Product(int product_id, String name, String brand, String category, String subCategory, int stock,
      int sold,
      String price, String description, Date creationDate, Date expirationDate) {

    this.product_id = product_id;
    this.name = name;
    this.brand = brand;
    this.category = category;
    this.subCategory = subCategory;
    this.stock = stock;
    this.sold = sold;
    this.price = price;
    this.description = description;
    this.creationDate = creationDate;
    this.expirationDate = expirationDate;
  }

  public int getProductId() {
    return this.product_id;
  }

  public void setProductId(int id) {
    this.product_id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSubCategory() {
    return this.subCategory;
  }

  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getSold() {
    return this.sold;
  }

  public void setSold(int sold) {
    this.sold = sold;
  }

  public String getPrice() {
    return this.price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreationDate() {
    return this.creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getExpirationDate() {
    return this.expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
}
