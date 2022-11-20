package com.example.banabada.repository;

import com.example.banabada.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//  @PersistenceContext
    private final EntityManager em;

    /*
    public MemberRepository(EntityManager em) {
        this.em = em;
    }
    */

    public void save(Member member) {
        em.persist(member);
        /*
        기본적으로는 persist만으로는 DB에 insert 되지 않는다.
        DB transaction이 commit될 때, refresh와 함께 insert 된다.
        (DB마다 다르긴 함)
        */
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // jpql에 대해 : from 절의 뒤는 Table이 아니라 Entity이다.
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    /*
    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }
    */
}
