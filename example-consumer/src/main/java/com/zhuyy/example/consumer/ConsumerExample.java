package com.zhuyy.example.consumer;

import com.zhuyy.example.common.model.User;
import com.zhuyy.example.common.service.UserService;
import com.zhuyy.zhurpc.proxy.ServiceProxyFactory;

public class ConsumerExample {
    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("zhuyy");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        }
    }

