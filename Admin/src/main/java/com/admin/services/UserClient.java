package com.admin.services;

import com.admin.server_request.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:1112", value = "user-client")
public interface UserClient
{
    @GetMapping("/user_info/for_order/{email}")
    UserInfo personalInfo(@PathVariable String email);

}
