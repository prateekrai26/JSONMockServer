package com.example.json.Manager;

import com.example.json.Service.PostService;
import com.example.json.Service.ReadFromJSONService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;

@Component
public class PostManager {

    @Autowired
    private PostService postService;
    @Autowired
    private ReadFromJSONService readFromJSONService;


    class SortByViewsASC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("views").toString()) < Integer.parseInt(b.get("views").toString()))
                return -1;
            return 1;
        }
    }
    class SortByViewsDSC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("views").toString()) < Integer.parseInt(b.get("views").toString()))
                return 1;
            return -1;
        }
    }
    class SortByReviewsASC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("reviews").toString()) < Integer.parseInt(b.get("reviews").toString()))
                return -1;
            return 1;
        }
    }
    class SortByReviewsDSC implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("reviews").toString()) < Integer.parseInt(b.get("reviews").toString()))
                return 1;
            return -1;
        }
    }
    class SortByID implements Comparator<JSONObject>{

        public int compare(JSONObject a , JSONObject b){
            if(Integer.parseInt(a.get("id").toString()) < Integer.parseInt(b.get("id").toString()))
                return -1;
            return 1;
        }
    }

    public JSONArray filterByTitle(JSONArray posts , String title){
        JSONArray results = new JSONArray();
        for(Object object : posts){
            JSONObject jsonObject = (JSONObject) object;
            if(jsonObject.get("title").toString().toLowerCase().startsWith(title.toLowerCase())){
                results.add(jsonObject);
            }
        }
        return results;
    }

    public JSONArray filterByAuthor(JSONArray posts , String author){
        JSONArray results = new JSONArray();
        for(Object object : posts){
            JSONObject jsonObject = (JSONObject) object;
            if(jsonObject.get("author").toString().toLowerCase().startsWith(author.toLowerCase())){
                results.add(jsonObject);
            }
        }
        return results;
    }
    public JSONArray filterByQuery(JSONArray posts , String query){
        JSONArray results = new JSONArray();
        for(Object object : posts){
            JSONObject jsonObject = (JSONObject) object;
             if(jsonObject.get("title").toString().toLowerCase().contains(query.toLowerCase()) || jsonObject.get("author").toString().toLowerCase().contains(query.toLowerCase())){
                 results.add(jsonObject);
             }
        }
        return results;
    }

    public JSONArray sortPosts(JSONArray posts , String sort , String order){
        if(sort.toLowerCase().equals("views")){
            if(order!=null && order.toLowerCase().equals("dsc"))
            Collections.sort(posts , new SortByViewsDSC());
            else
                Collections.sort(posts, new SortByViewsASC());
          }
        else{
            if(order!=null && order.toLowerCase().equals("dsc"))
                Collections.sort(posts , new SortByReviewsDSC());
            else
                Collections.sort(posts, new SortByReviewsASC());
        }
        return posts;
    }




}
