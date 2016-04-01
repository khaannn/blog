package com.khaannn;


import com.khaannn.couchbase.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        blogService.createUser("Khaannn", 9001, "test");
        blogService.doStuff();
        return "test";
    }
    public static void main(String[] args) {
        SpringApplication.run(BlogController.class, args);
    }
}
