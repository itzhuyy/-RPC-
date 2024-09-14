package com.zhuyy.example.provider;

import com.zhuyy.example.common.model.User;
import com.zhuyy.example.common.service.UserService;

public class UserServicerImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名"+user.getName());
        return user;
    }
}
