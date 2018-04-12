package be.biggerboat.service;

import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import be.biggerboat.utilities.exceptions.ParksharkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    public List<Division> readDivisions() {
        return divisionRepository.getDivisions();
    }

    public Division createSubDivision(int divisionId, Division subDivision) {
        divisionRepository.getDivision(divisionId)
                .addSubDivision(subDivision);
        return subDivision;
    }
}
