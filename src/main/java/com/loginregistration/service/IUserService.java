package com.loginregistration.service;

import com.loginregistration.model.User;

public interface IUserService {
    User register(User user);

    User login(String userName, String password);
}
