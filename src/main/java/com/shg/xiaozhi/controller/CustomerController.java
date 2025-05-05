package com.shg.xiaozhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @RequestMapping("/chat")
    public String chat() {
        System.out.println("进入聊天页面");
        return "chat";
    }
}
