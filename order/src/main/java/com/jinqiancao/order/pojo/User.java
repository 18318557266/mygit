package com.jinqiancao.order.pojo;

/**
 * @author jinqiancao
 * @date 2022/1/16 15:19
 */

public class User {

    private String name;

    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
