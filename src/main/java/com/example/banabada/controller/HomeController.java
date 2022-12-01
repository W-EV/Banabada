package com.example.banabada.controller;

import com.example.banabada.model.Item;
import com.example.banabada.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j  // Logger 대신
public class HomeController {

//  Logger log = LoggerFactory.getLogger(getClass()); // import org.slf4j.Logger

    private final ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {
        log.info("home controller");
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "index";
    }
}
