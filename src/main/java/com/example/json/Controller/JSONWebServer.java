package com.example.json.Controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;

@RestController
public class JSONWebServer {

    @GetMapping("/home")
    public void test() throws  Exception {



    }
}
