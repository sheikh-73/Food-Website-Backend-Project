package com.user.services;

import com.user.dto.Food;
import com.user.dto.ForOrderInfo;
import com.user.dto.GetOrder;
import com.user.entities.Cart;
import com.user.entities.UserAddress;
import com.user.entities.UserInfo;
import com.user.repositories.CartRepository;
import com.user.repositories.UserAddressRepository;
import com.user.repositories.UserInfoRepository;
import com.user.server_request.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserInfoRepository infoRepository;
    @Autowired
    private UserAddressRepository addressRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminClient adminClient;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public ResponseEntity<?> registration(UserInfo userInfo, UserAddress userAddress)
    {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfo.setUserAddress(userAddress);
        userAddress.setInfo(userInfo);

        infoRepository.save(userInfo);
        return ResponseEntity.ok("Hello, "+userInfo.getName()+". Your registration complete. Thank you with us.");
    }

    @Override
    public ResponseEntity<?> login(Login login)
    {
        UserInfo info = infoRepository.findByEmail(login.getEmail());
        if(info != null)
        {
            if(passwordEncoder.matches(login.getPassword(), info.getPassword()))
            {
                return ResponseEntity.ok("Welcome "+info.getName());
            }
            return ResponseEntity.ok("incorrect password !");
        }
        return ResponseEntity.ok("incorrect email !");
    }

    @Override
    public ResponseEntity<?> personalInfo(String email)
    {
        return ResponseEntity.ok(infoRepository.findByEmail(email));
    }

    @Override
    public ResponseEntity<?> menu()
    {
        return adminClient.menu();
    }

    @Override
    public Food getItem(String tittle)
    {
        return adminClient.getItem(tittle);
    }

    @Override
    public ResponseEntity<?> addToCart(Cart cart)
    {
        cartRepository.save(cart);
        return ResponseEntity.ok("item added successful.");
    }

    @Override
    public ResponseEntity<?> viewCart()
    {
        List<Cart> carts = cartRepository.findAll();
        List<Food> foods = new ArrayList<>();
        ResponseEntity<List<Food>> f;
        for(int i=0; i< carts.size(); i++)
        {
            foods.add(adminClient.getItem(carts.get(i).getItem()));
        }
        return ResponseEntity.ok(foods);
    }

    @Override
    public ResponseEntity<?> deleteOneItem(String item)
    {
        Cart cart = cartRepository.findByItem(item);
        cartRepository.deleteById(cart.getId());
        return ResponseEntity.ok("delete successful !");
    }

    @Override
    public ResponseEntity<?> deleteAllItem()
    {
        cartRepository.deleteAll();
        return ResponseEntity.ok("all item delete successful !");
    }

    @Override
    public ForOrderInfo userInfoForOrder(String email)
    {
        UserInfo info = infoRepository.findByEmail(email);
        ForOrderInfo order = new ForOrderInfo(info.getName(), info.getPhone(), info.getUserAddress().getFlatNo(), info.getUserAddress().getBuildingName(), info.getUserAddress().getAreaName());
        return order;
    }

    @Override
    public String getOrder(GetOrder getOrder) {
        return adminClient.getOrder(getOrder);
    }


}
