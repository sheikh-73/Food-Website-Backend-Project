package com.admin.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_address")
public class AdminAddress
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String flatNo;
    private String buildingName;
    private String areaName;
    private String  townName;
    private String cityName;
    private String stateName;
    private String countryName;


    @OneToOne
    @JoinColumn(name = "admin_info")
    private AdminInfo adminInfo;

    public AdminAddress(long id, String flatNo, String buildingName, String areaName, String townName, String cityName, String stateName, String countryName, AdminInfo adminInfo) {
        this.id = id;
        this.flatNo = flatNo;
        this.buildingName = buildingName;
        this.areaName = areaName;
        this.townName = townName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.adminInfo = adminInfo;
    }

    public AdminAddress() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    @Override
    public String toString() {
        return "AdminAddress{" +
                "id=" + id +
                ", flatNo='" + flatNo + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", townName='" + townName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", adminInfo=" + adminInfo +
                '}';
    }
}
