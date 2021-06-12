package com.example.json.Service;

import com.example.json.Entity.Author;
import com.example.json.Manager.AuthorManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;

@Service
public class AuthorService {

    @Autowired
    private ReadFromJSONService readFromJSONService;

    @Autowired
    private WriteIntoJSONService writeIntoJSONService;

    @Autowired
    private AuthorManager authorManager;

    public JSONArray read(String firstName , String lastName  , String sort , String order , String query){
         JSONArray jsonArray = readFromJSONService.readAuthor();
          if(firstName!=null){
              jsonArray= authorManager.filterByFirstName(jsonArray , firstName);
          }
          if(lastName!=null ){
              jsonArray= authorManager.filterByLastName(jsonArray,lastName);
          }
          if(sort!=null){
              jsonArray = authorManager.sortAuthors(jsonArray , sort , order);
          }
          if(query!=null){
              jsonArray= authorManager.filterOnQuery(jsonArray, query);
          }
        return jsonArray;
    }



    public Object getAuthor(String authorId){
        JSONObject author = authorManager.findById(authorId);
        if(author==null)
        return "Author Not Exists";
        return author;
    }

    public String update(Author author , String authorId){
       boolean flag=  authorManager.updateById(authorId , author);
       if(flag)
           return "Author Details Updated Successfully";

       return  "AuthorID is not valid";
    }



    public String delete(String authorId) throws  Exception{
        JSONArray jsonArray = readFromJSONService.readAuthor();
        Boolean flag= false;
        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.get("authorId").equals(authorId)){
                jsonArray.remove(object);
                flag = true;
                break;
            }
        }
        if(flag==false)
            return "AuthorId Not Exists";
        writeIntoJSONService.writeAuthor(jsonArray);
        return "Author Deleted Successfully";
    }

    public String  write(Author author){

        try {
            JSONArray jsonArray = readFromJSONService.readAuthor();
            JSONObject obj = new JSONObject();
            obj.put("authorId" , author.getAuthorId());
            obj.put("firstName" , author.getFirstName());
            obj.put("lastName" , author.getLastName());
            obj.put("posts" , 0);
            ObjectMapper objectMapper= new ObjectMapper();
            Integer x=0;
            for(Object object : jsonArray){
                JSONObject jsonObject= (JSONObject) object;
                String s= jsonObject.get("authorId").toString();
                if(s.equals(author.getAuthorId()))
                    return "AuthorID Already Exists";
                x= Math.max(x , Integer.parseInt(jsonObject.get("id").toString()));
            }
            obj.put("id" ,x+1);
            jsonArray.add(obj);
          writeIntoJSONService.writeAuthor(jsonArray);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Author Successfully Added";
    }

    boolean validateAuthor(String authorId){
        try {
            JSONArray jsonArray = readFromJSONService.readAuthor();
            String y=  authorId.toString();
            for(Object object : jsonArray){
                JSONObject jsonObject= (JSONObject) object;
                String s= jsonObject.get("authorId").toString();
                if(s.equals(y)){
                    return true;
                }
            }
        }
        catch (Exception e){

        }
        return false;
    }
    public void decreasePost(String authorId){
        try{
            JSONArray jsonArray = readFromJSONService.readAuthor();
            String y=  authorId.toString();
            for(Object object : jsonArray){
                JSONObject jsonObject= (JSONObject) object;
                String s= jsonObject.get("authorId").toString();

                if(s.equals(y)){
                    String x = jsonObject.get("posts").toString();
                    Integer post = Integer.parseInt(x);
                    jsonObject.replace("posts" ,post-1);
                    writeIntoJSONService.writeAuthor(jsonArray);
                }
            }

        }
        catch (Exception e){

        }
    }
    public void increasePost(String authorId){
        try{
            JSONArray jsonArray = readFromJSONService.readAuthor();
            String y=  authorId.toString();
            for(Object object : jsonArray){
                JSONObject jsonObject= (JSONObject) object;
                String s= jsonObject.get("authorId").toString();
                if(s.equals(y)){
                    String x = jsonObject.get("posts").toString();
                    Integer post = Integer.parseInt(x);
                    jsonObject.replace("posts" ,post+1);
                    writeIntoJSONService.writeAuthor(jsonArray);
                }
            }

        }
        catch (Exception e){

        }
    }


}
