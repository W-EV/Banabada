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

    public Payment findOne(Long id){return em.find(Payment.class, id);}

    public List<Payment> findAll(){
        return em.createQuery("select p from Payment p", Payment.class)
                .getResultList();
    }
}
