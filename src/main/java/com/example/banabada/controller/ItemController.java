package com.example.banabada.controller;

import com.example.banabada.model.Item;
import com.example.banabada.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String alreadyCreate() {
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

            itemService.saveItem(item1);
            itemService.saveItem(item2);
            itemService.saveItem(item3);
            itemService.saveItem(item4);
            itemService.saveItem(item5);
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

    //Item가져오기

    @GetMapping("/items")
    public String list(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "/products/";
    }

    /*
    상품 업데이트 == 추후수정예정
    @GetMapping("items/{itemid}/edit")
    public String updateItemForm(@PatchMapping("itemId") Long itemId, Model model){
        ItemForm form = new ItemForm();
        form.setId(Item.getId());
        form.setName(form.getName());
        form.setPrice(form.getPrice());
        form.setStockQuantity(form.getStockQuantity());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") ItemForm form){
        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
    }
     */

    /*상품수정
    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
        Item item = (Item) itemService.findOne(itemId);

        ItemForm form = new ItemForm();
        form.setId(item.getId());
        form.setName(for.getName());
        form.setPrice(form.getPrice());
        form.setQuantity(form.getStockQuantity());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }
     */

    /* 상품수정
    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") ItemForm form){

        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());

        /*참고
        Item item = new Item();
        item.setId(form.getId());
        item.setName(form.getName());
        item.setPrice(form.getPrice());
        item.setStockQuantity(form.getStockQuantity());

        itemService.saveItem(item);
         //

        return "redirect:/items";
    }
    */

}
