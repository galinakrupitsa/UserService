package org.example.userservice.Controller;
import org.example.userservice.Model.Users;
import org.example.userservice.Repository.UserRepository;
import org.example.userservice.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    public final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public Users getUser(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }
    @PostMapping ("/user/create")
    public Users createUser(@RequestBody Users user) {
        return userService.createUsers(user);
    }


}
