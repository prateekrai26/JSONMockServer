package com.example.json.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

@Service
public class WriteIntoJSONService {


    @Autowired
    private ReadFromJSONService readFromJSONService;

    public void write(JSONArray jsonArray , String fileName){
        try{
            try(FileWriter fileWriter= new FileWriter("src/main/java/com/example/json/res/" + fileName)){
                fileWriter.write(jsonArray.toJSONString());
                fileWriter.flush();
            }
        }
        catch (Exception e){

        }
    }
    public void writePost(JSONArray jsonArray){
        JSONObject store = readFromJSONService.readStore();
        store.replace("posts", jsonArray);
        writeStore(store);
    }

    public void writeAuthor(JSONArray jsonArray){
        JSONObject store = readFromJSONService.readStore();
        store.replace("authors" , jsonArray);
        writeStore(store);
    }
    public void writeStore(JSONObject jsonObject){
        try{
            try(FileWriter fileWriter= new FileWriter("store.json")){
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.flush();
            }
        }
        catch (Exception e){

        }
    }
}
