package com.yeshu.web.webApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsList;

    @RequestMapping("/Products")
    public List<Products> ProductPages(){
        return productsList.getProduct();
    }
}
