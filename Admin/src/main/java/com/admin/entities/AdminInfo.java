package com.admin.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_info")
public class AdminInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToOne(mappedBy = "adminInfo", cascade = CascadeType.ALL)
    private AdminAddress adminAddress;

    public AdminInfo(long id, String name, String email, String phone, String password, AdminAddress adminAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.adminAddress = adminAddress;
    }

    public AdminInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminAddress getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(AdminAddress adminAddress) {
        this.adminAddress = adminAddress;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", adminAddress=" + adminAddress +
                '}';
    }
}
