package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/intro")
public class TestController {

    /*
    Если мы используем аннотацию @ResponseBody, то возвращаемое значение будет строка, если этой аннотации не будет,
    тогда в качестве возвращаемого значения будет подставляться файл templates/intro.html.
     */

    //@ResponseBody
    @GetMapping(value = "/getinfo/")
    public String getInfo() {
        return "intro";
    }

}
