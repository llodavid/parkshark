package be.biggerboat.api.parkinglots;

import be.biggerboat.api.addresses.AddressMapper;
import be.biggerboat.domain.parkinglots.ParkingLot;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ParkingLotMapper {

    @Inject
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
