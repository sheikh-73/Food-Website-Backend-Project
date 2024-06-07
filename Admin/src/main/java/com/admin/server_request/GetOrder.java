package com.admin.server_request;

public class GetOrder
{
    private String userName;
    private String itemName;
    private int quantity;
    private String payment;

    public GetOrder() {
    }

    public GetOrder(String userName, String itemName, int quantity, String payment) {
        this.userName = userName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.payment = payment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "GetOrder{" +
                "userName='" + userName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", payment='" + payment + '\'' +
                '}';
    }
}
