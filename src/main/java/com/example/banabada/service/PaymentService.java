package com.example.banabada.service;

import com.example.banabada.model.Payment;
import com.example.banabada.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Long create(Payment payment){

        paymentRepository.save(payment);

        return payment.getId();
    }

    //주문전체조회
    public List<Payment> findPayments(){return paymentRepository.findAll();}

    //단건조회
    public Payment findOnePayment(Long paymentId){return paymentRepository.findOne(paymentId);}



}
