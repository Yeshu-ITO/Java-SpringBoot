package com.yeshu.web.app.QuizApp.controller;

import com.yeshu.web.app.QuizApp.service.MarkLogicConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkLogicConnectionController {

    @Autowired
    MarkLogicConnectionService mlcs;

    @RequestMapping("/")
    public void update(){
        String xml = "<root>Yeshwanth</root>";
        mlcs.updateDocument("/first",xml);
    }
}
