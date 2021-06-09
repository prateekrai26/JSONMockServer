package com.example.json.Service;

import com.example.json.Entity.Post;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ReadFromJSONService readFromJSONService;

    @Autowired
    private WriteIntoJSONService writeIntoJSONService;

    public String add(Post post){
        try {
            String authorId= post.getAuthor();
            if(!authorService.validateAuthor(authorId)){
                return "Author is not Valid";
            }
            JSONArray jsonArray = readFromJSONService.readPosts();
            System.out.println(jsonArray);
            Integer id = getId(jsonArray);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id" , id);
            jsonObject.put("title", post.getTitle());
            jsonObject.put("author", post.getAuthor());
            jsonObject.put("views" , 0);
            jsonObject.put("reviews" , 0);
            jsonArray.add(jsonObject);
            authorService.increasePost(post.getAuthor().toString());
            writeIntoJSONService.writePost(jsonArray);
        }
        catch (Exception e){

        }
     return "Post Created Successfully";
    }

    public String delete(Integer postId){
        try{
            JSONArray jsonArray = readFromJSONService.readPosts();
            boolean flag= false;
            String author="";
            for(Object object : jsonArray){
                JSONObject jsonObject = (JSONObject)object;
                if(jsonObject.get("id").toString().equals(postId.toString())){
                    author= jsonObject.get("author").toString();
                    jsonArray.remove(object);
                    flag = true;
                    break;
                }
            }
            if(flag==false)
                return "PostId is not valid";
            authorService.decreasePost(author);
            writeIntoJSONService.writePost(jsonArray);
        }
        catch (Exception e){

        }

        return "Post Deleted Successfully";
    }
    public Integer getId(JSONArray jsonArray){
        Integer x=0;
        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject) object;
            x= Math.max(x , Integer.parseInt(jsonObject.get("id").toString()));
        }
        return x+1;
    }

    public Object getPost(Integer postId){
        try{
            JSONArray jsonArray = readFromJSONService.readPosts();
            for(Object object : jsonArray){
                JSONObject jsonObject = (JSONObject)object;
                if(jsonObject.get("id").toString().equals(postId.toString())){
                    Integer views = Integer.parseInt(jsonObject.get("views").toString());
                     jsonObject.replace("views" , views+1);
                     writeIntoJSONService.writePost(jsonArray);
                    return jsonObject;
                }
            }

        }
        catch (Exception e){
        }

        return "No Post Available for this postID";
    }

    public Object getAllPost(){
        try{
            JSONArray jsonArray = readFromJSONService.readPosts();
           if(jsonArray.isEmpty())
           {
               return "No Post Available";
           }
           return jsonArray;
        }
        catch (Exception e){

        }
        return "No Post Available";
    }

    public String update(Post post , Integer postId){
        try{
            JSONArray jsonArray = readFromJSONService.readPosts();
            boolean flag= false;
            for(Object object : jsonArray){
                JSONObject jsonObject = (JSONObject)object;
                if(jsonObject.get("id").toString().equals(postId.toString())){
                   if(post.getAuthor() !=null){
                       if(authorService.validateAuthor(post.getAuthor())){
                           String oldAuthorId = jsonObject.get("author").toString();
                           String newAuthorId= post.getAuthor().toString();
                           if(!newAuthorId.equals(oldAuthorId)){
                               authorService.increasePost(newAuthorId);
                               authorService.decreasePost(oldAuthorId);
                           }
                           jsonObject.replace("author" , post.getAuthor());
                           jsonObject.replace("title" ,post.getTitle());
                           writeIntoJSONService.writePost(jsonArray);
                       }
                       else
                       {
                           return "New Author is not Valid";
                       }
                   }
                   else{
                       jsonObject.replace("title" ,post.getTitle());
                       writeIntoJSONService.writePost(jsonArray);
                   }

                   break;
                }
            }


        }
        catch (Exception e){

        }
        return "Post Updated Successfully";
    }


}
