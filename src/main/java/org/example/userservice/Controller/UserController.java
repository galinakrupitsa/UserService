package org.example.userservice.Controller;

import org.apache.catalina.User;
import org.example.userservice.DTO.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/user/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return new UserResponse();
    }

}
