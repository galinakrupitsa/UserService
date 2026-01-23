package org.example.userservice.Service;

import org.apache.catalina.User;
import org.example.userservice.Model.Users;
import org.example.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Users createUsers(Users user) {
        return userRepository.create(user.firstName, user.secondName);
    }


}
