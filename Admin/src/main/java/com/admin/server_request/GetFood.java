package com.admin.server_request;

import java.awt.*;

public class GetFood
{
    private String tittle;
    private String description;
    private double mainPrice;
    private double discountPrice;
    private String category;
    //private Image image;

    public GetFood() {
    }

    public GetFood(String tittle, String description, double mainPrice, double discountPrice, String category /* , Image image */) {
        this.tittle = tittle;
        this.description = description;
        this.mainPrice = mainPrice;
        this.discountPrice = discountPrice;
        this.category = category;
        //this.image = image;
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

    public double getMainPrice() {
        return mainPrice;
    }

    public void setMainPrice(double mainPrice) {
        this.mainPrice = mainPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }

    @Override
    public String toString() {
        return "GetFood{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", mainPrice=" + mainPrice +
                ", discountPrice=" + discountPrice +
                ", category='" + category + '\'' +
                //", image=" + image +
                '}';
    }
}
