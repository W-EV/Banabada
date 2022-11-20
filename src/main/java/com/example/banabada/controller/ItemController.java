package com.example.banabada.controller;

import com.example.banabada.model.Item;
import com.example.banabada.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /* 상품등록페이지부분 추후추가나 수정예정
    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }
     */

    @PostMapping("/items/new")
    public String create() {
        //Item 등록하기
        if (itemService.findItems().stream().count() < 5) {
            //item이 5개 미만이면 등록

            Item item1 = new Item();
            item1.setName("채소1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);
            item1.setProductImgPath("image/path");
            item1.setProductInfo("오이,감자");

            Item item2 = new Item();
            item2.setName("채소1");
            item2.setPrice(10000);
            item2.setStockQuantity(5);
            item2.setProductImgPath("image/path");
            item2.setProductInfo("오이,감자");

            Item item3 = new Item();
            item1.setName("채소1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);
            item1.setProductImgPath("image/path");
            item1.setProductInfo("오이,감자");

            Item item4 = new Item();
            item1.setName("채소1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);
            item1.setProductImgPath("image/path");
            item1.setProductInfo("오이,감자");

            Item item5 = new Item();
            item1.setName("채소1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);
            item1.setProductImgPath("image/path");
            item1.setProductInfo("오이,감자");
        }

        return "/products/"; //상품목록페이지로 가기
    }



        /*
        private String name;
        private int price;
        private int stockQuantity;
        private String productImgPath;
        private String productInfo;
         */



}
