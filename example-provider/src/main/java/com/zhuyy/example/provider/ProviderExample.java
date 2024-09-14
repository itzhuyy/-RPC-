package com.zhuyy.example.provider;

import com.zhuyy.example.common.service.UserService;
import com.zhuyy.zhurpc.registry.LocalRegistry;
import com.zhuyy.zhurpc.server.HttpServer;
import com.zhuyy.zhurpc.server.VerxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServicerImpl.class);

        //启动web服务
        HttpServer httpServer = new VerxHttpServer();
        httpServer.doStart(8080);
    }
}
