package ru.orangeraze.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor

public class IndexController {
    @GetMapping("/index")
    public String registration() {
        return "index";
    }

    @GetMapping("/features")
    public String features() {
        return "features";
    }

    @GetMapping("/about")
    public String about() {
        return "about-us";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }


}
