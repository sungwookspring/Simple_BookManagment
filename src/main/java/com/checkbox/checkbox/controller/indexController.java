package com.checkbox.checkbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    /***
     * Index 페이지
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
