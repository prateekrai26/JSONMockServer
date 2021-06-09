package com.example.json.Manager;

import com.example.json.Entity.Author;
import com.example.json.Service.ReadFromJSONService;
import com.example.json.Service.WriteIntoJSONService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorManager {

    @Autowired
    ReadFromJSONService readFromJSONService;

    @Autowired
    private WriteIntoJSONService writeIntoJSONService;

    public JSONObject findById(String authorId){
        JSONArray jsonArray = readFromJSONService.readAuthor();
        for(Object object : jsonArray){
            JSONObject jsonObject= (JSONObject) object;
            if(jsonObject.get("authorId").toString().equals(authorId.toString())){
                return jsonObject;
            }
        }
        return null;
    }

    public Boolean updateById(String authorId , Author author){
        JSONArray jsonArray = readFromJSONService.readAuthor();
        Boolean flag= false;
        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.get("authorId").toString().equals(authorId.toString())){
                if(author.getFirstName()!=null)
                    jsonObject.replace("firstName" , author.getFirstName());

                if(author.getLastName()!=null)
                    jsonObject.replace("lastName" , author.getLastName());

                if(author.getPosts()!=null)
                    jsonObject.replace("posts" , author.getPosts());

                flag = true;
                break;
            }
        }
        if(flag==false)
            return false;

        writeIntoJSONService.writeAuthor(jsonArray);

        return true;
    }


}
