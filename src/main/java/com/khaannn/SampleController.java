package com.khaannn;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


/**
 * Created by chatham_j on 3/25/2016.
 */

@Controller
public class SampleController {


    @RequestMapping("/about")
    String about(){
        return "about";
    }

    @RequestMapping(value = {"/","/index","/Index", "/INDEX"})
    String index() { return "index";}

    @RequestMapping("/contact")
    String contact() { return "contact";}

    @RequestMapping("/post")
    String post() { return "post";}




    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
