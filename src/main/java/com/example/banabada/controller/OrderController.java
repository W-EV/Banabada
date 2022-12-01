package com.example.banabada.controller;

import com.example.banabada.model.*;
import com.example.banabada.repository.OrderSearch;
import com.example.banabada.service.ItemService;
import com.example.banabada.service.MemberService;
import com.example.banabada.service.OrderService;
import com.example.banabada.service.PaymentService;
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
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;
    private final PaymentService paymentService;


    // 상품 상세 페이지 --> 주문하기 버튼 클릭 --> 주문 페이지로 이동
    // 주문(상품 콤보박스 입력) --> 결제하기 버튼 클릭 --> 결제 페이지로 이동
    // 결제 페이지 폼(결제 수단 콤보박스) --> 결제 버튼 클릭 --> 결제 내역 및 배송 정보 페이지로 이동

    /*
    @GetMapping("/banabada/orders")
    public String orders(Model model) {
        memberService.findMembers().get(0).getOrders(0).get
        model.addAttribute("payment", paymentService.findPayments());
        return "orderReady";
    }

     */
    @GetMapping("/banabada/orders")
    public String order() {
        return "orderReady";
    }

    @PostMapping("/banabada/orders")
    public String order(@RequestParam(name = "itemName", required = false) String itemName,
                        @RequestParam(name = "payMethod", required = false) String payMethod
                        )
    {
        Member member = memberService.findMembers().get(0);  // 회원이 1명밖에 없으므로.
        Item item = itemService.findName(itemName);



        Long orderId = orderService.order(member.getId(), item.getId(), payMethod);
        //Order order = orderService.findOrder(orderId);
        log.info("*******************주문 객체 생성 된 후");

        return "redirect:/"; //결제 완료 시 홈페이지로 가기 , 확인은 구독 관리 페이지에서 할 수 있도록 함
    }

    @GetMapping("/banabada/orders/orderList")
    public String list(Model model) {
        model.addAttribute("orders", orderService.findOrders());
        return "orderList";
    }




    /*
    @GetMapping("/mypage/{userId}/subscription")  // 구독 관리 페이지 == 주문 내역 페이지
    public String createForm(Model model, @PathVariable(required = false) Long userId) {

        Member member = memberService.findOne(userId);
        List<Item> items = itemService.findItems();  //??? 사용자와 상품 join한 후, findItems() 할 것

        model.addAttribute("member", member);
        model.addAttribute("items", items);

        return "/mypage/{userId}/subscription";   // redirect는 뭐지?
    }
    */







    /* 안 쓰는 기능일 것 같음.
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

     */














}
