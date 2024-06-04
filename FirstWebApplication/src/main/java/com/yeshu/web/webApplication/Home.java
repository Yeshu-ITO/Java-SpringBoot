package com.yeshu.web.webApplication;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String greetMessage(){
        return  "Welcome to the First Application";
    }

    @RequestMapping("/About")
    public String aboutPage(){
        return "This is the About Page";
    }
}
