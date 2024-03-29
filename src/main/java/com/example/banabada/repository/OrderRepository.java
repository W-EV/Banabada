package com.example.banabada.repository;

import com.example.banabada.model.Order;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {em.persist(order);}

    public Order findOne(Long id) { return em.find(Order.class, id);}

    public List<Order> findAll(){ return em.createQuery("select o from Order o", Order.class)
            .getResultList();
    }

    /*
    무슨 문제가 있냐면요 11.23
    >> 1회 에 member와 1:1로 주문 연결되는데 아래 코드는 모든 주문을 다 보여줌
    그럴 필요가 없음
    일단 업데이트시 쓸 수 있으니 남겨두겠음
    위의 findAll()로 변경

    public List<Order> findAllByString(OrderSearch orderSearch) {

        String jpql = "select o from Order o join o.member m";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if (orderSearch.getOrderStatus() != null){
            if(isFirstCondition){
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += "o.status = :status";
        }

        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            if(isFirstCondition){
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += "m.name like :name";
        }

        //자료형 이용 :
        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000); //최대 1000건
        if (orderSearch.getOrderStatus() != null){
            query = query.setParameter("status", orderSearch.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearch.getMemberName())){
            query = query.setParameter("status", orderSearch.getMemberName());
        }

        return query.getResultList();

    }

     */



    /*JPA Criteria : 비추방법들
    public List<Order> findByCriteria(OrderSearch orderSearch){
        CriteriaBuilder db = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuary(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);
    }
    ...
     */

}
