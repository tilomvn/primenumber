package com.interview.project.primenumber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
}
