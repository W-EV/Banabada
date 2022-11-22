package com.example.banabada.repository;

import com.example.banabada.model.Delivery;
import com.example.banabada.model.Item;
import com.example.banabada.model.Order;
import com.example.banabada.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor //생성자
public class DeliveryRepository {

    private final EntityManager em;

    //배송할 아이템
    public void save(Delivery delivery){
        em.persist(delivery); } //Delivery 객체 저장

    //id값으로 검색하면 단건조회
    //Delivery에서 배송건 가져오기
    public Delivery findOne(Long id){ return em.find(Delivery.class, id); }

    //findAll 하면 배송정보 가지고오기
    public List<Delivery> findAll() {
        return em.createQuery("select d from Delivery d", Delivery.class) //from절 뒤 Item은 ItemEntity를 뜻함
                .getResultList();
    }
}
