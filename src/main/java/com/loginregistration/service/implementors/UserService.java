package com.loginregistration.service.implementors;


import com.loginregistration.model.User;
import com.loginregistration.repository.IUserRepository;
import com.loginregistration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User register(User user) {
        user.setRegisterDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User login(String userName, String password) {
        List<User> byUsername = userRepository.findAll();
        User user = byUsername.stream()
                .filter(userData -> userData.getUserName().equals(userName))
                .filter(userData -> userData.getPassword().equals(password))
                .findFirst()
                .get();
        return user;
    }
}