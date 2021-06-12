package com.example.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;

@SpringBootApplication
public class JsOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsOnApplication.class, args);
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonObject.put("posts", jsonArray);
            jsonObject.put("authors", jsonArray);
            System.out.println(jsonObject);
            try (FileWriter fileWriter = new FileWriter("store.json");) {
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.flush();
            }
        }
        catch (Exception e){

        }


    }

}
