package com.example.demo2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Addbillboard {
    @GetMapping(path="/addbillboard")
    public String add_board(){
        return "add_board";
    }
}
