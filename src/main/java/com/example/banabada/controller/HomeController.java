package com.example.banabada.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j  // Logger 대신
public class HomeController {

//  Logger log = LoggerFactory.getLogger(getClass()); // import org.slf4j.Logger
    @GetMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}
