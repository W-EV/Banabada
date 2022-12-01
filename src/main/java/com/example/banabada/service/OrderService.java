package com.example.banabada.service;

import com.example.banabada.model.*;
import com.example.banabada.repository.*;
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
    private final PaymentRepository paymentRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, String payMethod){

        //엔터티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);
        //Payment payment = paymentRepository.findOne(paymentId);

        //배송정보 설정
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //결제 정보 설정
        Payment paymentObject = new Payment();
        /*무엇이 문제냐면요 11.23
        payment.setPayMethod("신용카드"); // 결제 수단 추후 입력받는 기능 혹은 제거
        결제수단 신용카드 || 현금 으로 설정하려함
        사용자가 "신용카드"라고 정확히 적어야 결제가 진행되는 문제
        >> 프론트페이지에 콤보박스 (신용카드 || 현금) 표시하고 선택하게 하기
        >> 백엔드에서는 어떻게 해야 할까요?
        ==>
         */
        paymentObject.setTotalPrice(item.getPrice());
        paymentObject.setPayMethod(payMethod);

        //주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice()); //OrderItem에 메서드 생성해야함

        //주문 생성
        Order order = Order.createOrder(member, delivery, paymentObject, orderItem); //Order에 메서드 생성해야함

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

    public List<Order> findOrders(){
        return orderRepository.findAll();
    }

    //검색
    public Order findOrder(Long id) {
        return orderRepository.findOne(id);
    }

    // public List<Order> findOrders(OrderSearch orderSearch){
        //return orderRepository.findAll();
    //}



}


