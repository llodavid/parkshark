package be.biggerboat.api.parkinglots;

import be.biggerboat.domain.parkinglots.ParkingLot;

import javax.inject.Named;

@Named
public class ParkingLotMapper {

    public ParkingLotDto toDto(ParkingLot parkingLot) {
        return new ParkingLotDto()
                .withId(parkingLot.getId())
                .withName(parkingLot.getName())
                .withCapacity(parkingLot.getCapacity())
                .withDivision(parkingLot.getDivision())
                .withPricePerHour(parkingLot.getPricePerHour());
    }

    public ParkingLot toDomain(ParkingLotDto parkingLotDto) {
        return new ParkingLot(parkingLotDto.name, parkingLotDto.division, parkingLotDto.capacity, parkingLotDto.pricePerHour);

    }
}
