package com.admin.server_request;

public class Order
{
    private String email;
    private String itemName;
    private int quantity;
    private String payment;

    public Order(String email, String itemName, int quantity, String payment) {
        this.email = email;
        this.itemName = itemName;
        this.quantity = quantity;
        this.payment = payment;
    }

    public Order() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "email='" + email + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", payment='" + payment + '\'' +
                '}';
    }
}
