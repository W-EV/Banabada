package com.example.banabada.controller;

import com.example.banabada.model.Member;
import com.example.banabada.model.Order;
import com.example.banabada.model.Item;
import com.example.banabada.repository.OrderSearch;
import com.example.banabada.service.ItemService;
import com.example.banabada.service.MemberService;
import com.example.banabada.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;



    @GetMapping("/mypage/{userId}/subscription")  // 구독 관리 페이지 == 주문 내역 페이지
    public String createForm(Model model, @PathVariable(required = false) Long userId) {

        Member member = memberService.findOne(userId);
        List<Item> items = itemService.findItems();  //??? 사용자와 상품 join한 후, findItems() 할 것

        model.addAttribute("member", member);
        model.addAttribute("items", items);

        return "/mypage/{userId}/subscription";   // redirect는 뭐지?
    }

    @PostMapping("/order")  // 주문하기 버튼을 눌렀을 때
    public String order(@RequestParam("memberId") Long memberId,  // memberId는 front html의 name 속성값
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {

        orderService.order(memberId, itemId, count);
        return "redirect:/orders/payments";   // 주문 버튼 클릭 시, 결제 페이지로 넘어감

    }




    //* 안 쓰는 기능일 것 같음.
    @GetMapping(value = "/orders/orderList")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }

    // 주문 취소 : 추가 기능으로써 현재 구현하지 않음
    @PostMapping("/mypage/{userId}/subscription")  // /mypage/{userId}/subscription 페이지에서 '주문 취소' 버튼 누를 때 URL
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/mypage/{userId}/subscription";
    }














}
