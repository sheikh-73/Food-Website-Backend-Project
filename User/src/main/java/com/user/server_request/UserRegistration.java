package com.user.server_request;

import com.user.entities.UserAddress;
import com.user.entities.UserInfo;

public class UserRegistration
{
    private UserInfo info;
    private UserAddress address;

    public UserRegistration() {
    }

    public UserRegistration(UserInfo info, UserAddress address) {
        this.info = info;
        this.address = address;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "info=" + info +
                ", address=" + address +
                '}';
    }
}
