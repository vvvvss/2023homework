package com.homework5.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/KeelungSightWeb")
    public String setWeb(){
        return "KeelungSightWeb";
    }
}
