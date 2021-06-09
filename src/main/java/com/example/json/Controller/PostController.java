package com.example.json.Controller;


import com.example.json.Entity.Post;
import com.example.json.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    @Autowired
     private PostService postService;
    @PostMapping("/add")
    public String add(@RequestBody Post post){

         return postService.add(post);
    }

    @GetMapping("/get-posts-list")
    public Object getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/get-post/{postId}")
    public Object getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }

    @PutMapping("/update/{postId}")
    public String update(@PathVariable Integer postId, @RequestBody Post post){
        return postService.update(post  , postId);
    }
    @DeleteMapping("/delete/{postId}")
    public String delete(@PathVariable Integer postId){
        return postService.delete(postId);
    }
}
