package com.example.banabada.controller;

import com.example.banabada.model.Delivery;
import com.example.banabada.model.DeliveryStatus;
import com.example.banabada.service.DeliveryService;
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
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/banabada/orders/delivery")
    public String delivery(){
        return "deliveryForm";
    }

    @PostMapping("/banabada/orders/delivery")
    public String delivery(@RequestParam(name = "address", required = false) String address)
                          //@RequestParam(name = "status", required = false) DeliveryStatus deliveryStatus >>오류나서일단보류
                           {

        Delivery delivery = new Delivery();

        delivery.setAddress(address);
        //delivery.setStatus(deliveryStatus.READY); 오류나서 일단 보류


        log.info("*******************배송 객체 생성 되기 전");
        deliveryService.create(delivery);
        log.info("*******************배송 객체 생성 된 후");
        log.info(deliveryService.findDeliveries().get(0).getAddress());

        return "redirect:/"; //결제 완료 시 홈페이지로 가기 , 확인은 구독 관리 페이지에서 할 수 있도록 함
    }



    @GetMapping("/banabada/orders/deliveryList")
    public String list(Model model) {
        model.addAttribute("deliveries", deliveryService.findDeliveries());
        return "deliverySuccess";
    }
}