package com.example.banabada.repository;

import com.example.banabada.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor //생성자
public class ItemRepository {

    private final EntityManager em;

    //아이템 저장
    public void save(Item item){
        if(item.getId() == null){ //DB에 저장되기 전에 id가 부여되지 않으므로 = 새로운 객체 의미
            em.persist(item);
        } else {
            em.merge(item); //업데이트 의미, 이미 등록된 item임
        }
    }

    //id값으로 검색하면 item 하나를 주는거
    public Item findOne(Long id){ return em.find(Item.class, id); }

    //findAll 하면 Item 객체 다 가져오기
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class) //from절 뒤 Item은 ItemEntity를 뜻함
                .getResultList();
    }
}
