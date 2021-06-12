package com.example.json.Controller;
import com.example.json.Entity.Author;
import com.example.json.Service.AuthorService;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
     private AuthorService authorService;


    @PostMapping("/authors")
    public String addAuthor(@RequestBody Author author){

        return authorService.write(author);

    }
    @DeleteMapping("/authors/{authorId}")
    public String  delete(@PathVariable String authorId) throws  Exception{
        return authorService.delete(authorId);
    }

     @GetMapping("/authors/{authorId}")
     public Object getAuthor(@PathVariable String authorId) throws  Exception{
        return authorService.getAuthor(authorId);
     }
    @GetMapping("/authors")
    public JSONArray getAuthors(@RequestParam(required = false) String first_name ,@RequestParam(required = false) String last_name ,@RequestParam(required = false) String sort ,
                                @RequestParam(required = false) String order ,@RequestParam(required = false) String q){
        JSONArray jsonArray= authorService.read(first_name , last_name, sort , order,q);
        return jsonArray;
    }
    @PutMapping("/authors/{authorId}")
    public String update(@PathVariable String authorId , @RequestBody Author author) throws IOException, ParseException {
        try {
            return authorService.update(author, authorId);
        }
        catch (Exception e){

        }
            return "AuthorID not Exists";
    }










}
