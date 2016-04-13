package com.khaannn;


import com.khaannn.couchbase.repository.Post;
import com.khaannn.couchbase.repository.User;
import com.khaannn.couchbase.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chatham_j on 3/25/2016.
 */

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/about")
    String about(Model model){
        String content = "up in here<p/> Testing self closing tag.";
        model.addAttribute("content", content);
        return "about";
    }

    @RequestMapping(value = {"/","/index","/Index", "/INDEX"})
    String index() { return "index";}

    @RequestMapping("/contact")
    String contact() { return "contact";}

    @RequestMapping("/post")
    String post() { return "post";}

    @RequestMapping("/footer")
    String footer() { return "footer";}

    @RequestMapping("/test")
    String test() {
        blogService.deleteAll();
        User user = new User("Khaannn", 9001, "test");
        blogService.createUser(user);
        blogService.doStuff();
        blogService.getAllPosts();
        return "test";
    }

    @RequestMapping("/allPosts")
    public String allPosts(){
        List<Post> posts = blogService.getAllPosts();
        for(Post post : posts){
           System.out.println(post);
        }
        return "allPosts";
    }


    @RequestMapping(value="/newPost", method=RequestMethod.GET)
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "newPost";
    }

    @RequestMapping(value="/newPost", method=RequestMethod.POST)
    public String createPostEditor(@ModelAttribute Post post){
        try {
            blogService.insertPost(post);
        } catch (Exception e){
            return "fail";
        }
        return "viewPost";


    }



    public static void main(String[] args) {
        SpringApplication.run(BlogController.class, args);
    }
}
