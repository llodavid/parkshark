package be.biggerboat.api.parkinglots;

import be.biggerboat.api.addresses.AddressDto;
import be.biggerboat.domain.divisions.Division;

import java.util.Objects;

public class ParkingLotDto {
    public int id;
    public String name;
    public Division division;
    public int capacity;
    public double pricePerHour;
    public AddressDto address;

    public ParkingLotDto withId(int id){
        this.id = id;
        return this;
    }

    public ParkingLotDto withName(String name){
        this.name = name;
        return this;
    }

    public ParkingLotDto withDivision(Division division){
        this.division = division;
        return this;
    }

    public ParkingLotDto withCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }

    public ParkingLotDto withPricePerHour(double pricePerHour){
        this.pricePerHour = pricePerHour;
        return this;
    }

    public ParkingLotDto withAddress(AddressDto address){
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotDto that = (ParkingLotDto) o;
        return id == that.id &&
                capacity == that.capacity &&
                Double.compare(that.pricePerHour, pricePerHour) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(division, that.division);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, division, capacity, pricePerHour);
    }
}
