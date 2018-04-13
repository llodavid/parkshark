package be.biggerboat.domain.parkinglots;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.divisions.Division;
import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARKING_LOTS")
public class ParkingLot {


    @SequenceGenerator(name = "parking_lot_id_seq", sequenceName = "parking_lot_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_id_seq")
    @Id
    @Column(name = "PARKING_LOT_ID")
    private int id;
    @Column(name = "PARKING_LOT_NAME")
    private String name;
    @OneToOne
    @JoinColumn(name ="FK_DIVISION_ID")
    private Division division;
    @Column(name = "PARKING_CAPACITY")
    private int capacity;
    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;


    @Embedded
    private Address address;


    public ParkingLot() {
    }

    public ParkingLot(String name, Division division, int capacity, double pricePerHour, Address address) {
        if (isFilledIn(name) && isFilledIn(capacity) && isFilledIn(pricePerHour) &&isFilledIn(division)) {
            this.name = name;
            this.division = division;
            this.capacity = capacity;
            this.pricePerHour = pricePerHour;
            this.address = address;
        } else {
            throw new ParksharkException("Please fill in all the required fields.");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Division getDivision() {
        return division;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isFilledIn(Object data) {
        return data != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return getId() == that.getId() &&
                getCapacity() == that.getCapacity() &&
                Double.compare(that.getPricePerHour(), getPricePerHour()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDivision(), that.getDivision()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDivision(), getCapacity(), getPricePerHour(), getAddress());
    }

}
