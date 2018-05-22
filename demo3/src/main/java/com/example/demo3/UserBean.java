package com.example.demo3;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class UserBean {


    private String name;
    private int img;


    public UserBean(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
