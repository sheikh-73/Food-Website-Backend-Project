package com.user.services;

import com.user.dto.Food;
import com.user.dto.ForOrderInfo;
import com.user.dto.GetOrder;
import com.user.entities.Cart;
import com.user.entities.UserAddress;
import com.user.entities.UserInfo;
import com.user.server_request.Login;
import com.user.server_request.OrderReq;
import org.springframework.http.ResponseEntity;

public interface UserService
{
    ResponseEntity<?> registration(UserInfo info, UserAddress address);
    ResponseEntity<?> login(Login login);
    ResponseEntity<?> personalInfo(String email);

    ResponseEntity<?> menu();

    Food getItem(String tittle);
    ResponseEntity<?> addToCart(Cart cart);
    ResponseEntity<?> viewCart();

    ResponseEntity<?> deleteOneItem(String item);
    ResponseEntity<?> deleteAllItem();

    ForOrderInfo userInfoForOrder(String email);

    String getOrder(GetOrder getOrder);
}
