package be.biggerboat.api.divisions;

import be.biggerboat.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/divisions")
public class DivisionController {

    private DivisionService divisionService;
    private DivisionMapper divisionMapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = "application/json")
    public DivisionDTO createDivision(@RequestBody DivisionDTO divisionDTO) {
        return divisionMapper.divisionToDTO(
                divisionService.createDivision(
                        divisionMapper.dtoToDivision(divisionDTO)));
    }
}
