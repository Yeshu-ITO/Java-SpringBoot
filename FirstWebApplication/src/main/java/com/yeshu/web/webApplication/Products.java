package com.yeshu.web.webApplication;


import org.springframework.stereotype.Component;

@Component
public class Products {

    int id;
    String name;

    public Products(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
