package com.user.services;

import com.user.dto.Food;
import com.user.dto.GetOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:1111", value = "admin-client")
public interface AdminClient
{
    @GetMapping("/menu")
    ResponseEntity<?> menu();

    @GetMapping("/item/{tittle}")
    Food getItem(@PathVariable String tittle);

    @PostMapping("/get-order")
    String getOrder(@RequestBody GetOrder saveOrder);

}
