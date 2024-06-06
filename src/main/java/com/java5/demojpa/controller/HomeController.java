package com.java5.demojpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/users")
    public String getProductPage() {
        return "user/body/user";
    }

    @GetMapping("/users/id")
    public String getEditProductPage(@RequestParam("id") Long id) {
        return "user/body/edit-user";
    }
}
