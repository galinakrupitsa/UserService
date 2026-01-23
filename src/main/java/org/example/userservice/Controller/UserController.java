package org.example.userservice.Controller;

import org.apache.catalina.User;
import org.example.userservice.DTO.UserResponse;
import org.example.userservice.Model.Users;
import org.example.userservice.Repository.UserRepository;
import org.example.userservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    public final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/user/{userId}")
    public Users getUser(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }
    @PostMapping ("/user/create")
    public Users createUser(@RequestBody Users user) {
        return userRepository.create(user.firstName, user.secondName);
    }


}
