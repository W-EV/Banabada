package com.example.banabada.controller;

import com.example.banabada.model.Payment;
import com.example.banabada.model.PaymentStatus;
import com.example.banabada.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/banabada/orders/payment")
    public String payment(){
        return "paymentForm";
        }

    @PostMapping("/banabada/orders/payment")
    public String payment(@RequestParam(name = "payMethod", required = false) String payMethod,
                          @RequestParam(name = "totalPrice", required = false) int totalPrice) {

        Payment payment = new Payment();

        payment.setPayMethod(payMethod);
        payment.setTotalPrice(totalPrice);
        payment.setStatus(PaymentStatus.CANCEL);

        log.info("*******************결제 객체 생성 되기 전");
        paymentService.create(payment);
        log.info("*******************결제 객체 생성 된 후");
        log.info(paymentService.findPayments().get(0).getPayMethod());

        return "redirect:/"; //결제 완료 시 홈페이지로 가기 , 확인은 구독 관리 페이지에서 할 수 있도록 함
    }



    @GetMapping("/banabada/orders/paymentList")
    public String list(Model model) {
        model.addAttribute("payments", paymentService.findPayments());
        return "paymentList";
    }




}
