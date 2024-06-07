package com.admin.server_request;

import com.admin.entities.AdminAddress;
import com.admin.entities.AdminInfo;

public class AdminRegistration
{
    private AdminInfo info;
    private AdminAddress address;

    public AdminRegistration() {
    }

    public AdminRegistration(AdminInfo info, AdminAddress address) {
        this.info = info;
        this.address = address;
    }

    public AdminInfo getInfo() {
        return info;
    }

    public void setInfo(AdminInfo info) {
        this.info = info;
    }

    public AdminAddress getAddress() {
        return address;
    }

    public void setAddress(AdminAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AdminRegistration{" +
                "info=" + info +
                ", address=" + address +
                '}';
    }
}
