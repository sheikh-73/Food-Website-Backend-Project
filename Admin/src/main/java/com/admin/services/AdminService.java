package com.admin.services;

import com.admin.entities.*;
import com.admin.server_request.GetFood;
import com.admin.server_request.GetOrder;
import com.admin.server_request.Login;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public interface AdminService
{
    ResponseEntity<?> registration(AdminInfo info, AdminAddress address);
    ResponseEntity<?> login(Login login);
    ResponseEntity<?> addCategory(Category category);
    ResponseEntity<?> viewCategory();
    ResponseEntity<?> addFood(Food food);
    ResponseEntity<?> viewAllFood() throws SQLException, IOException;
    ResponseEntity<?> deleteOneFoodItem(String tittle);
    GetFood viewOneFood(String tittle) throws IOException, SQLException;
    ResponseEntity<?> viewCategoryFoods(String category);
    ResponseEntity<?> personalInfo(String email);
    String getOrder(GetOrder saveOrder);

    List<UserOrder> getAllOrders();

}
