package com.admin.services;

import com.admin.entities.*;
import com.admin.repositories.*;
import com.admin.server_request.GetFood;
import com.admin.server_request.GetOrder;
import com.admin.server_request.Login;
import com.admin.server_request.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminInfoRepository infoRepository;
    @Autowired
    private AdminAddressRepository addressRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private UserClient userClient;
    @Autowired
    private UserOrderRepository userOrderRepository;


    @Override
    public ResponseEntity<?> registration(AdminInfo info, AdminAddress address)
    {
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        info.setAdminAddress(address);
        address.setAdminInfo(info);
        infoRepository.save(info);

        return ResponseEntity.ok("Hello, "+info.getName()+". Your Registration complete. Thank you with us.");
    }

    @Override
    public ResponseEntity<?> login(Login login)
    {
        AdminInfo info = infoRepository.findByEmail(login.getEmail());
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
    public ResponseEntity<?> addCategory(Category category)
    {
        categoryRepository.save(category);
        return ResponseEntity.ok("successful !");
    }

    @Override
    public ResponseEntity<?> viewCategory()
    {
        List<String> list = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for(int i=0; i< categoryList.size(); i++)
        {
            list.add(categoryList.get(i).getItemName());
        }

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> addFood(Food food)
    {
        foodRepository.save(food);
        return ResponseEntity.ok("food add successful !");
    }


    // ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);

    @Override
    public ResponseEntity<?> viewAllFood() throws SQLException, IOException {
        List<Food> foodList = foodRepository.findAll();
        List<GetFood> allFoodList = new ArrayList<>();
        for(int i=0; i<foodList.size(); i++)
        {
            // convert image:
            byte[] imageBytes = foodList.get(i).getImage().getBytes(1, (int) foodList.get(i).getImage().length());
            InputStream inputStream = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            Image image = (Image) bufferedImage;

            // calculate discount price:
            double discountPrice = (foodList.get(i).getPrice()) - (foodList.get(i).getPrice() * (foodList.get(i).getDiscount() / 100));


            allFoodList.add(new GetFood(foodList.get(i).getTittle(), foodList.get(i).getDescription(), foodList.get(i).getPrice(), discountPrice, foodList.get(i).getCategory()));
        }
        return ResponseEntity.ok(allFoodList);
    }

    @Override
    public ResponseEntity<?> deleteOneFoodItem(String tittle)
    {
        Food food = foodRepository.findByTittle(tittle);
        foodRepository.deleteById(food.getId());
        return ResponseEntity.ok("food item delete successful ! ");
    }

    @Override
    public GetFood viewOneFood(String tittle) throws IOException, SQLException {
        Food food = foodRepository.findByTittle(tittle);

        // convert image:
        byte[] imageBytes = food.getImage().getBytes(1, (int) food.getImage().length());
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        Image image = (Image) bufferedImage;

        // calculate discount price:
        double discountPrice = (food.getPrice()) - (food.getPrice() * (food.getDiscount() / 100));

        GetFood obj = new GetFood(food.getTittle(), food.getDescription(), food.getPrice(), discountPrice, food.getCategory());

        return obj;
    }

    @Override
    public ResponseEntity<?> viewCategoryFoods(String category)
    {
        List<Food> foods = foodRepository.findByCategory(category);
        List<GetFood> getFoods = new ArrayList<>();
        for(int i=0; i< foods.size(); i++)
        {
            double discount = foods.get(i).getPrice() - (foods.get(i).getPrice() * (foods.get(i).getDiscount() / 100));
            getFoods.add(new GetFood(foods.get(i).getTittle(), foods.get(i).getDescription(), foods.get(i).getPrice(), discount, foods.get(i).getCategory()));
        }

        return ResponseEntity.ok(getFoods);
    }

    @Override
    public ResponseEntity<?> personalInfo(String email)
    {
        return ResponseEntity.ok(infoRepository.findByEmail(email));
    }

    @Override
    public String getOrder(GetOrder saveOrder)
    {
        UserInfo info = userClient.personalInfo(saveOrder.getUserName());
        Food food = foodRepository.findByTittle(saveOrder.getItemName());
        double totalPrice = food.getPrice()*saveOrder.getQuantity();
        UserOrder userOrder = new UserOrder(
              info.getName(),
              info.getPhoneNumber(),
              food.getTittle(),
                saveOrder.getQuantity(),
                totalPrice,
                saveOrder.getPayment(),
                "pending",
                info.getFlatNo(),
                info.getBuildingName(),
                info.getAreaName()
        );

        System.out.println(userOrder);

        userOrderRepository.save(userOrder);
        return "Order Done !";
    }

    @Override
    public List<UserOrder> getAllOrders()
    {
        return userOrderRepository.findAll();
    }


}
