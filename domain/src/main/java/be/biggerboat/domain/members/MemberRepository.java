package be.biggerboat.domain.members;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Member registerMember(Member member){
        entityManager.persist(member);
        return member;
    }

    public MemberRepository() {
    }
}
