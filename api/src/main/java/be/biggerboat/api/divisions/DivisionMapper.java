package be.biggerboat.api.divisions;

import be.biggerboat.domain.divisions.Division;

import javax.inject.Named;

@Named
public class DivisionMapper {

    public DivisionDTO divisionToDTO(Division division) {
        return new DivisionDTO()
                .withId(division.getId())
                .withDivisionName(division.getDivisionName())
                .withOriginalName(division.getOriginalName())
                .withDirector(division.getDirector());
    }

    public Division dtoToDivision(DivisionDTO divisionDTO) {
        return new Division(divisionDTO.divisionName,
                divisionDTO.originalName,
                divisionDTO.director);
    }
}
