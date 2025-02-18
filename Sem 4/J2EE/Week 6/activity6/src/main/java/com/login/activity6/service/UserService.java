package com.login.activity6.service;

import com.login.activity6.model.User;
import com.login.activity6.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        logger.info("Adding a new user: {}", user.getUsername());
        userRepository.save(user);
    }

    public User userLogin(String userName, String password) {
        logger.info("Fetching user by name from the database");
        List<User> userList = userRepository.findByUsername(userName);

        if (userList != null && !userList.isEmpty()) {
            User user = userList.get(0);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }
}
