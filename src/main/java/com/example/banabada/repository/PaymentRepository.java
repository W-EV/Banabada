package com.example.banabada.repository;

import com.example.banabada.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentRepository {

    private final EntityManager em;

    public void save(Payment payment){
        em.persist(payment);
    }

    //id값 주면 결제id가.. 뭐얏쥐
    public Payment findOne(Long id){return em.find(Payment.class, id);}

    //findAll하면 결제정보 가져오기
    public List<Payment> findAll(){
        return em.createQuery("select p from Payment p", Payment.class)
                .getResultList();
    }
}
