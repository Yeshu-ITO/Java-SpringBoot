package com.yeshu.web.app.QuizApp.controller;

import com.yeshu.web.app.QuizApp.service.MarkLogicConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MarkLogicConnectionController {

    @Autowired
    MarkLogicConnectionService marklogicconnectionservice;

    @RequestMapping(value = "/AllDocuments")
    public String documentList(){
        String xquery = "doc() ! document-uri(.)";
        return marklogicconnectionservice.allDocuments(xquery);
    }

    @RequestMapping("/AddNewNode")
    public String addNewNode(){
        String xquery = "doc() ! xdmp:node-insert-child(/root, element newNode{\"New Node Added\"})\n";
        return marklogicconnectionservice.addNewNode(xquery);
    }
}
