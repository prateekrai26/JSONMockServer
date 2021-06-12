package com.example.json.Manager;

import com.example.json.Entity.Author;
import com.example.json.Service.ReadFromJSONService;
import com.example.json.Service.WriteIntoJSONService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;

@Component
public class AuthorManager {

    @Autowired
    ReadFromJSONService readFromJSONService;

    @Autowired
    private WriteIntoJSONService writeIntoJSONService;

    class SortAuthorsOnPostsASC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("posts").toString()) < Integer.parseInt(b.get("posts").toString())){
                return -1;
            }
            return 1;
        }
    }
    class SortAuthorsOnPostsDSC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("posts").toString()) < Integer.parseInt(b.get("posts").toString())){
                return 1;
            }
            return -1;
        }
    }


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

                flag = true;
                break;
            }
        }
        if(flag==false)
            return false;

        writeIntoJSONService.writeAuthor(jsonArray);

        return true;
    }

    public JSONArray filterByFirstName(JSONArray authors , String firstName){
        JSONArray results = new JSONArray();
        for(Object object : authors){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.get("firstName").toString().toLowerCase().startsWith(firstName.toLowerCase())){
                results.add(jsonObject);
            }
        }
        return results;
    }
    public JSONArray filterByLastName(JSONArray authors , String lastName){
        JSONArray results = new JSONArray();
        for(Object object : authors){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.get("lastName").toString().toLowerCase().startsWith(lastName.toLowerCase())){
                results.add(jsonObject);
            }
        }
        return results;
    }
    public JSONArray sortAuthors(JSONArray authors , String sort , String order){
         if(order!=null && order.toLowerCase().equals("dsc")){
              Collections.sort(authors, new SortAuthorsOnPostsDSC());
         }
         else
             Collections.sort(authors, new SortAuthorsOnPostsASC());
         return authors;
    }
    public JSONArray filterOnQuery(JSONArray authors , String query){
        JSONArray results = new JSONArray();
        for(Object object : authors){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.get("lastName").toString().toLowerCase().contains(query.toLowerCase()) || jsonObject.get("firstName").toString().toLowerCase().contains(query.toLowerCase()) ){
                results.add(jsonObject);
            }
        }
        return results;
    }

}
