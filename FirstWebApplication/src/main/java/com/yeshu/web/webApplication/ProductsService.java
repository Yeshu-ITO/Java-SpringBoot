package com.yeshu.web.webApplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductsService {

    List<Products> li = Arrays.asList(
            new Products(1, "Car"),
            new Products(2, "Bike"),
            new Products(3, "Bicycle")
    );

    public List<Products> getProduct(){
        return  li;
    }
}
