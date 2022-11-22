package com.example.banabada.repository;

import com.example.banabada.model.Delivery;
import com.example.banabada.model.Item;
import com.example.banabada.model.Order;
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

    //id값으로 검색하면 item 하나를 주는거
    public Item findOne(Long id){ return em.find(Item.class, id); }

    //findAll 하면 Item 객체 다 가져오기
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class) //from절 뒤 Item은 ItemEntity를 뜻함
                .getResultList();
    }
}
