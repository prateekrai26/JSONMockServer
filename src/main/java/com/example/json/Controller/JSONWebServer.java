package com.example.json.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONWebServer {

    @GetMapping("/home")
    public void test(@RequestParam(required = false) Integer id , @RequestParam(required = false) String authorID){
        System.out.println(id);
        System.out.println(authorID);
    }


}
