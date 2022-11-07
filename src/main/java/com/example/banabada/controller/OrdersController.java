package com.example.banabada.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banabada/orders")
public class OrdersController {


    /*/ 장바구니, 주문, 결제 페이지
    @GetMapping("/cart")
    //로그인이 디폴트인지?? if 로그인이 디폴트 : "cart/{id}"
    Cart Cart = user.getCart();

    //장바구니에 들어있는 아이템 가져오기
    List<CartItem> cartItemList = cartService.allUserCartView(Cart);


    //장바구니 들어있는 상품의 총 가격을 표시할 것인가??
    int totalPrice = 0;
    for 문으로 cartitemCOUNT * cartITEMPRICE returncon

    //장바구니 삭제 구현은??



    @GetMapping("/orderList")


    @PostMapping("/payments")


    //*/



}
