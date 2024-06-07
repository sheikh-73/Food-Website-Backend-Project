package com.admin.controller;

import com.admin.entities.Category;
import com.admin.entities.Food;
import com.admin.entities.UserOrder;
import com.admin.server_request.AdminRegistration;
import com.admin.server_request.GetFood;
import com.admin.server_request.GetOrder;
import com.admin.server_request.Login;
import com.admin.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class AdminController
{
    @Autowired
    private AdminService service;

    @PostMapping("/admin/registration")
    private ResponseEntity<?> registration(@RequestBody AdminRegistration registration)
    {
        return service.registration(registration.getInfo(), registration.getAddress());
    }

    @GetMapping("/admin/login")
    private ResponseEntity<?> login(@RequestBody Login login)
    {
        return service.login(login);
    }

    @PostMapping("/admin/add-category")
    private ResponseEntity<?> addCategory(@RequestBody Category category) { return service.addCategory(category); }

    @GetMapping("/view-category")
    private ResponseEntity<?> viewCategory() { return service.viewCategory(); }

    @PostMapping("/admin/add-food")
    private ResponseEntity<?> addFood(@RequestParam("tittle") String tittle,
                                      @RequestParam("description") String description,
                                      @RequestParam("price") double price,
                                      @RequestParam("discount") double discount,
                                      @RequestParam("category") String category,
                                      @RequestParam("image")MultipartFile file
                                      ) throws IOException, SQLException {
        if(!file.isEmpty())
        {
            byte[] imageByte = file.getBytes();
            Blob image = new SerialBlob(imageByte);
            Food food = new Food(tittle, description, price, discount, category, image);

            return service.addFood(food);
        }
        return ResponseEntity.ok("empty file !");
    }

    @GetMapping("/menu")
    private ResponseEntity<?> viewAllFood() throws SQLException, IOException {
        return service.viewAllFood();
    }

    @GetMapping("/delete-item/{tittle}")
    private ResponseEntity<?> deleteOneFoodItem(@PathVariable String tittle)
    {
        return service.deleteOneFoodItem(tittle);
    }

    @GetMapping("/item/{tittle}")
    private GetFood viewOneFood(@PathVariable String tittle) throws SQLException, IOException
    {
        return service.viewOneFood(tittle);
    }

    @GetMapping("/menu/category/{category}")
    private ResponseEntity<?> viewCategoryFoods(@PathVariable String category)
    {
        return service.viewCategoryFoods(category);
    }
    @GetMapping("/admin/personal-info/{email}")
    private ResponseEntity<?> personalInfo(@PathVariable String email)
    {
        return service.personalInfo(email);
    }

    @PostMapping("/get-order")
    private String getOrder(@RequestBody GetOrder saveOrder)
    {
        return service.getOrder(saveOrder);
    }
    @GetMapping("/show/orders")
    private List<UserOrder> getAllOrders()
    {
        return service.getAllOrders();
    }

}
