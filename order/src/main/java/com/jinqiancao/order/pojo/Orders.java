package com.jinqiancao.order.pojo;

/**
 * @author jinqiancao
 * @date 2022/3/4 21:42
 */
public class Orders {
    private Integer id;
    private String name;
    private Integer number;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
