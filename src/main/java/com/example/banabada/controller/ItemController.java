package com.example.banabada.controller;

import com.example.banabada.model.Item;
import com.example.banabada.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    @GetMapping ("/banabada/createdb")  // Post
    public String alreadyCreate() {
        //Item 등록하기
        if (itemService.findItems() != null) {  ///??????????
            //item이 하나도 없는 경우

            Item item1 = new Item();
            item1.setName("채소set1");
            item1.setPrice(10000);
            item1.setStockQuantity(5);                  //상품재고관리 : 자동화x 손수입력값을 수정 / 추후에 자동화 예정(왜냐면 지금은 규모가 작으니까)
            item1.setProductImgPath("src/main/resources/templates/images/banabada (1).jpg");
            item1.setProductInfo("토마토, 양배추");

            Item item2 = new Item();
            item2.setName("채소set2");
            item2.setPrice(11000);
            item2.setStockQuantity(6);
            item2.setProductImgPath("https://images.unsplash.com/photo-1546793665-c74683f339c1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80");
            item2.setProductInfo("호박, 고구마");

            Item item3 = new Item();
            item3.setName("채소set3");
            item3.setPrice(12000);
            item3.setStockQuantity(7);
            item3.setProductImgPath("https://images.unsplash.com/photo-1572449043416-55f4685c9bb7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80");
            item3.setProductInfo("당근, 오이");

            Item item4 = new Item();
            item4.setName("채소set4");
            item4.setPrice(13000);
            item4.setStockQuantity(8);
            item4.setProductImgPath("src/main/resources/templates/images/banabada (2).jpg");
            item4.setProductInfo("오이,감자");

            Item item5 = new Item();
            item5.setName("채소set5");
            item5.setPrice(14000);
            item5.setStockQuantity(9);
            item5.setProductImgPath("src/main/resources/templates/images/banabada (3).jpg");
            item5.setProductInfo("방울토마토, 올리브");

            itemService.saveItem(item1);
            itemService.saveItem(item2);
            itemService.saveItem(item3);
            itemService.saveItem(item4);
            itemService.saveItem(item5);

            List<Item> its = itemService.findItems();

            log.info("데이터베이스를 만들었습니다." + its.get(0).getName() + its.get(1).getName()+ its.get(2).getName()+ its.get(3).getName()+ its.get(4).getName());
        }
        else {
            log.info("데이터베이스를 만들지 못했습니다.");
        }

        return "redirect:/"; // 홈 페이지
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
        log.info("아이템이 존재하는지 다시 확인합니다." + items.get(3).getName());
        model.addAttribute("items", items);
        return "products";
    }


    // 상품 상세 조회
    @GetMapping("/banabada/products/{itemId}")  // 상품 상세 페이지
    public String detailList(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.findOne(itemId);
        if (item != null) {
            model.addAttribute("item", item);
            return "productsDetail";
        } else {
            return "noproducts";    // 해당하는 상품 id가 존재하지 않습니다.
        }
    }

    //--> 상품 상세 페이지에서 '주문하기' 버튼을 누르면 '주문' 정보 완성한 후, '결제' 페이지로 이동하는 것으로 가정


}
