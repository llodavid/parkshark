package be.biggerboat.api.parkinglots;

import be.biggerboat.service.parkinglots.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto createParkingLotDto(@RequestBody ParkingLotDto parkingLotDto) {
        return parkingLotMapper.toDto(
                parkingLotService.createParkingLot(
                        parkingLotMapper.toDomain(parkingLotDto)));
    }


}
