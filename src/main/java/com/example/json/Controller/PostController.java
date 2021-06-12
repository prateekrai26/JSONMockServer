package com.example.json.Controller;


import com.example.json.Entity.Post;
import com.example.json.Manager.PostManager;
import com.example.json.Service.PostService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
     private PostService postService;

    @Autowired
    private PostManager postManager;
    @PostMapping("/posts")
    public String add(@RequestBody Post post){

         return postService.add(post);
    }

    @GetMapping("/posts/{postId}")
    public Object getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }

    @PatchMapping("/posts/{postId}")
    public String update(@PathVariable Integer postId, @RequestBody Post post){
        return postService.update(post  , postId);
    }
    @DeleteMapping("/posts/{postId}")
    public String delete(@PathVariable Integer postId){
        return postService.delete(postId);
    }

    @GetMapping("/posts")
    public Object getPosts(@RequestParam(required = false) String title  , @RequestParam(required = false)  String author , @RequestParam(required = false) String sort
     ,@RequestParam(required = false) String order , @RequestParam(required = false) String q){
        return postService.fiterBasedOnParameters(title , author ,sort , order , q);
    }


}
