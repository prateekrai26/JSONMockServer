package com.example.json.Controller;
import com.example.json.Entity.Author;
import com.example.json.Service.AuthorService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
@RequestMapping(value = "/author" , produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
     private AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        return authorService.write(author);

    }
    @DeleteMapping("/delete/{authorId}")
    public String  delete(@PathVariable String authorId) throws  Exception{
        return authorService.delete(authorId);
    }

     @GetMapping("/get-author/{authorId}")
     public Object getAuthor(@PathVariable String authorId) throws  Exception{
        return authorService.getAuthor(authorId);
     }

    @GetMapping("/get-authors-list")
    public Object getAllAuthors(){

        return authorService.read();

    }

    @PutMapping("/update/{authorId}")
    public String update(@PathVariable String authorId , @RequestBody Author author) throws IOException, ParseException {
        try {
            return authorService.update(author, authorId);
        }
        catch (Exception e){

        }
            return "AuthorID not Exists";
    }










}
