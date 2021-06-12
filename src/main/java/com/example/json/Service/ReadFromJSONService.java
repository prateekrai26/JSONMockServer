package com.example.json.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;

@Service
public class ReadFromJSONService {

    private JSONParser jsonParser = new JSONParser();
    public JSONArray read(String fileName){
        JSONArray jsonArray = new JSONArray();
        try {
            try (FileReader fileReader = new FileReader("src/main/java/com/example/json/res/" + fileName)) {
                Object object = jsonParser.parse(fileReader);
                jsonArray = (JSONArray) object;
            }


        }catch (Exception e){

        }
        return jsonArray;
    }

    public JSONArray readPosts(){
        JSONObject jsonObject = readStore();
        return (JSONArray) jsonObject.get("posts");
    }
    public JSONArray readAuthor(){
        JSONObject jsonObject = readStore();
        return (JSONArray) jsonObject.get("authors");
    }

    public JSONObject readStore(){
        JSONObject jsonObject = new JSONObject();
        try {
            try (FileReader fileReader = new FileReader("store.json")) {
                Object object = jsonParser.parse(fileReader);
                jsonObject = (JSONObject) object;
            }
            return jsonObject;
        }catch (Exception e){

        }
        return jsonObject;
    }

 }
