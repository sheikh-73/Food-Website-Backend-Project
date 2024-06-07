package com.user.dto;

public class ForOrderInfo
{
    private String name;
    private String phoneNumber;
    private String flatNo;
    private String buildingName;
    private String areaName;

    public ForOrderInfo(String name, String phoneNumber, String flatNo, String buildingName, String areaName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flatNo = flatNo;
        this.buildingName = buildingName;
        this.areaName = areaName;
    }

    public ForOrderInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "ForOrderInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
