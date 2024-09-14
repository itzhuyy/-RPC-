package com.zhuyy.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.zhuyy.example.common.model.User;
import com.zhuyy.example.common.service.UserService;
import com.zhuyy.zhurpc.model.RpcRequest;
import com.zhuyy.zhurpc.model.RpcResponse;
import com.zhuyy.zhurpc.serializer.JdkSerializer;
import com.zhuyy.zhurpc.serializer.Serializer;

import java.io.IOException;

public class UserServiceProxy  implements UserService {

    public User getUser(User user) {
        Serializer serializer =  new JdkSerializer();
        RpcRequest rpcRequest =  RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[] {user})
                .build();
        try{
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[]  result;
            try (
                HttpResponse httpResponse = HttpRequest.post("http://localhost:8090")
                        .body(bodyBytes)
                        .execute()){
                    result = httpResponse.bodyBytes();
                }
                RpcResponse rpcResponse = serializer.deserialize(result,RpcResponse.class);
                return (User) rpcResponse.getData();
        }catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }

}
