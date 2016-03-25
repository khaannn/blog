package com.khaannn;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

/**
 * Created by chatham_j on 3/25/2016.
 */

@Controller
public class SampleController {

    @RequestMapping("/")
    String home(Model model){
        String name = "Jeff";
        model.addAttribute("name", name);
        return "helloworld";
    }

    @RequestMapping("/about")
    String about(){
        return "about";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
