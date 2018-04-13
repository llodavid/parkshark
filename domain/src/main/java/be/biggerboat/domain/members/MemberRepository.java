package be.biggerboat.domain.members;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MemberRepository {

    public MemberRepository() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Member registerMember(Member member){
        entityManager.persist(member);
        return member;
    }

    public Member readMemberbyId(int memberId) {
        return entityManager.find(Member.class, memberId);
    }

    public List<Member> readAllMembers() {
        return entityManager.createQuery("FROM Member", Member.class).getResultList();
    }
}
