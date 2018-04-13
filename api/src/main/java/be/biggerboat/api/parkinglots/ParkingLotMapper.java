package be.biggerboat.api.parkinglots;

import be.biggerboat.api.addresses.AddressMapper;
import be.biggerboat.domain.parkinglots.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;


import javax.inject.Named;

@Named
public class ParkingLotMapper {

    @Autowired
    private AddressMapper addressMapper;

    public ParkingLotDto toDto(ParkingLot parkingLot) {
        return new ParkingLotDto()
                .withId(parkingLot.getId())
                .withName(parkingLot.getName())
                .withCapacity(parkingLot.getCapacity())
                .withDivision(parkingLot.getDivision())
                .withPricePerHour(parkingLot.getPricePerHour())
                .withAddress(addressMapper.toDto(parkingLot.getAddress()));
    }

    public ParkingLot toDomain(ParkingLotDto parkingLotDto) {
        return new ParkingLot(parkingLotDto.name, parkingLotDto.division, parkingLotDto.capacity, parkingLotDto.pricePerHour, addressMapper.toDomain(parkingLotDto.address));

    }
}
