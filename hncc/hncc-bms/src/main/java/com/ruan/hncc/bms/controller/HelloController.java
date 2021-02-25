package com.ruan.hncc.bms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/cccc")
    public String s(){
        return "api/cccc";
    }

    @GetMapping("/api/yy/ccc")
    public String s2(){
        return "api/yy/ccc";
    }
    
}
