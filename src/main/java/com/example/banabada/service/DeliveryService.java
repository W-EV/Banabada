package com.example.banabada.service;

import com.example.banabada.model.Delivery;
import com.example.banabada.model.Payment;
import com.example.banabada.repository.DeliveryRepository;
import com.example.banabada.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Long create(Delivery delivery){

        deliveryRepository.save(delivery);

        return delivery.getId();
    }

    //배송전체조회
    public List<Delivery> findDeliveries(){return deliveryRepository.findAll();}

    //단건조회 :: (나중에) 가장 최근 배송건을 불러오거나 등등
    public Delivery findOneDelivery(Long deliveryId){return deliveryRepository.findOne(deliveryId);}
}
