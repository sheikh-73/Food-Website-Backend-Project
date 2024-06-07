package com.admin.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_order")
public class UserOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String phoneNumber;
    private String itemName;
    private int quantity;
    private double totalPrice;
    private String payment;
    private String status;
    private String flatNo;
    private String buildingName;
    private String areaName;

    public UserOrder() {
    }

    public UserOrder(long id, String userName, String phoneNumber, String itemName, int quantity, double totalPrice, String payment, String status, String flatNo, String buildingName, String areaName) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.status = status;
        this.flatNo = flatNo;
        this.buildingName = buildingName;
        this.areaName = areaName;
    }

    public UserOrder(String userName, String phoneNumber, String itemName, int quantity, double totalPrice, String payment, String status, String flatNo, String buildingName, String areaName) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.status = status;
        this.flatNo = flatNo;
        this.buildingName = buildingName;
        this.areaName = areaName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", payment='" + payment + '\'' +
                ", status='" + status + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
