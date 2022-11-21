package com.example.banabada.controller;

import com.example.banabada.model.Item;
import com.example.banabada.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;


    /* 상품 등록 페이지 없음
    @GetMapping("/banabada/createdb")
    public String createForm(Model model){
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }
    */


    // 상품 생성 기능 : Item 5개 미리 생성 (H2 데이터베이스 특성 문제, 게시글 등록 및 수정/삭제 기능 없애기 위함)
    @GetMapping ("/banabada/createdb")
    public String alreadyCreate() {
        //Item 등록하기
        if (itemService.findItems() == null) {
            //item이 하나도 없는 경우

            Item item1 = new Item();
            item1.setName("채소set1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);
            item1.setProductImgPath("image/path1");
            item1.setProductInfo("토마토, 양배추");

            Item item2 = new Item();
            item2.setName("채소set2");
            item2.setPrice(11000);
            item2.setStockQuantity(6);
            item2.setProductImgPath("image/path2");
            item2.setProductInfo("호박, 고구마");

            Item item3 = new Item();
            item1.setName("채소set3");
            item1.setPrice(12000);
            item1.setStockQuantity(7);
            item1.setProductImgPath("image/path3");
            item1.setProductInfo("당근, 오이");

            Item item4 = new Item();
            item1.setName("채소set4");
            item1.setPrice(13000);
            item1.setStockQuantity(8);
            item1.setProductImgPath("image/path4");
            item1.setProductInfo("오이,감자");

            Item item5 = new Item();
            item1.setName("채소set5");
            item1.setPrice(14000);
            item1.setStockQuantity(9);
            item1.setProductImgPath("image/path5");
            item1.setProductInfo("방울토마토, 올리브");

            itemService.saveItem(item1);
            itemService.saveItem(item2);
            itemService.saveItem(item3);
            itemService.saveItem(item4);
            itemService.saveItem(item5);

            log.info("데이터베이스를 만들었습니다.");
        }
        else {
            log.info("데이터베이스를 만들지 못했습니다.");
        }

        return "redirect:/banabada"; // 홈 페이지
    }
        /*
        private String name;
        private int price;
        private int stockQuantity;
        private String productImgPath;
        private String productInfo;
         */

    // 상품 목록 조회
    @GetMapping("/banabada/products")   // 상품 목록 페이지
    public String list(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "redirect:/banabada/products";
    }


    // 상품 상세 조회
    @GetMapping("/banabada/products/{itemId}")  // 상품 상세 페이지
    public String detailList(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "redirect:/banabada/products/{itemId}";
    }


}
