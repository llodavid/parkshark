package be.biggerboat.api.divisions;

import be.biggerboat.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createDivision(@RequestBody DivisionDTO divisionDTO) {
        return divisionMapper.divisionToDTO(
                divisionService.createDivision(
                        divisionMapper.dtoToDivision(divisionDTO)));
    }

    @PostMapping(path = "/{divisionId}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createSubDivision(@PathVariable int divisionId, @RequestBody DivisionDTO divisionDTO){
        return divisionMapper.divisionToDTO(
                divisionService.createSubDivision(divisionId,
                        divisionMapper.dtoToDivision(divisionDTO)));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDTO> readDivisions() {
        return divisionService.readDivisions().stream()
                .map(division -> divisionMapper.divisionToDTO(division))
                .collect(Collectors.toList());
    }
}
