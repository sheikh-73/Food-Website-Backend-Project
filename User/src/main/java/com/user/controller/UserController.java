package com.user.controller;

import com.user.dto.Food;
import com.user.dto.ForOrderInfo;
import com.user.dto.GetOrder;
import com.user.entities.Cart;
import com.user.entities.UserInfo;
import com.user.server_request.Login;
import com.user.server_request.OrderReq;
import com.user.server_request.UserRegistration;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class UserController
{
    @Autowired
    private UserService service;

    @PostMapping("/user/registration")
    private ResponseEntity<?> registration(@RequestBody UserRegistration registration)
    {
        return service.registration(registration.getInfo(), registration.getAddress());
    }

    @GetMapping("/user/login")
    private ResponseEntity<?> login(@RequestBody Login login)
    {
        return service.login(login);
    }

    @GetMapping("/user/personal-info/{email}")
    private ResponseEntity<?> personalInfo(@PathVariable String email)
    {
        return service.personalInfo(email);

    }

    @GetMapping("/menu")
    private ResponseEntity<?> menu()
    {
        return service.menu();
    }

    @GetMapping("/item/{tittle}")
    private Food getItem(@PathVariable String tittle)
    {
        return service.getItem(tittle);
    }

    @PostMapping("/user/add-cart")
    private ResponseEntity<?> addToCart(@RequestBody Cart cart)
    {
        return service.addToCart(cart);
    }
    @GetMapping("/user/view-cart")
    private ResponseEntity<?> viewCart()
    {
        return service.viewCart();
    }

    @DeleteMapping("/user/delete-item/{item}")
    private ResponseEntity<?> deleteOneItem(@PathVariable String item)
    {
        return service.deleteOneItem(item);
    }

    @DeleteMapping("/user/delete-items")
    private ResponseEntity<?> deleteItems()
    {
        return service.deleteAllItem();
    }

    @GetMapping("/user_info/for_order/{email}")
    private ForOrderInfo userInfoForOrder(@PathVariable String email)
    {
        return service.userInfoForOrder(email);
    }

    @PostMapping("/user/order")
    private String order(@RequestBody GetOrder getOrder)
    {
        return service.getOrder(getOrder);
    }


}
