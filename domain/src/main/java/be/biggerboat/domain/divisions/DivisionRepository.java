package be.biggerboat.domain.divisions;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DivisionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Division save(Division division){
        entityManager.persist(division);
        return division;
    }


    public List<Division> getDivisions() {
        return entityManager.createQuery("from Division",Division.class)
                .getResultList();
    }

    public Division getDivision(int divisionId) {
        return entityManager.find(Division.class,divisionId);
    }
}
