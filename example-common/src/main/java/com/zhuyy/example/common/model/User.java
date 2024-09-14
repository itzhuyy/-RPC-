package com.zhuyy.example.common.model;

public class User {
    private  String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User{name = " + name + "}";
    }
}
