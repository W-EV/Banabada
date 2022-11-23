package com.example.banabada.service;

import com.example.banabada.model.*;
import com.example.banabada.repository.ItemRepository;
import com.example.banabada.repository.MemberRepository;
import com.example.banabada.repository.OrderRepository;
import com.example.banabada.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    //주문
    private final OrderRepository orderRepository;

    //사용자
    private final MemberRepository memberRepository;

    //아이템
    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){

        //엔터티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 설정
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //결제 정보 설정
        Payment payment = new Payment();
        payment.setPayMethod("신용카드"); // 결제 수단 추후 입력받는 기능 혹은 제거
        payment.setTotalPrice(item.getPrice());

        //주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice()); //OrderItem에 메서드 생성해야함

        //주문 생성
        Order order = Order.createOrder(member, delivery, payment, orderItem); //Order에 메서드 생성해야함

        //주문 저장
        orderRepository.save(order); //OrderItem, Delivery가 자동으로 persist

        return order.getId();
    }

    // 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
    }

    //검색
    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByString(orderSearch);
    }
}


