package com.admin.entities;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "food")
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tittle;
    private String description;
    private double price;
    private double discount;
    private String category;
    @Lob
    private Blob image;

    public Food() {
    }

    public Food(long id, String tittle, String description, double price, double discount, String category, Blob image) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = image;
    }

    public Food(String tittle, String description, double price, double discount, String category, Blob image)
    {
        this.tittle = tittle;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category='" + category + '\'' +
                ", image=" + image +
                '}';
    }

}
