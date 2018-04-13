package be.biggerboat.service.parkinglots;

import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import be.biggerboat.domain.parkinglots.ParkingLot;
import be.biggerboat.domain.parkinglots.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

}
