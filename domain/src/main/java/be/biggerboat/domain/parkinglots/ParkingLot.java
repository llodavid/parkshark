package be.biggerboat.domain.parkinglots;

import be.biggerboat.domain.divisions.Division;
import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @SequenceGenerator(name = "parking_lot_seq", sequenceName = "parking_lot_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_seq")
    @Column(name = "PARKING_LOT_ID")
    private int id;
    @Column(name = "PARKING_LOT_NAME")
    private String name;
    @OneToOne
    @JoinColumn(name ="FK_DIVISION_ID")
    private Division division;
    @Column(name = "CAPACITY")
    private int capacity;
    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;

    private ParkingLot() {
    }

    public ParkingLot(String name, Division division, int capacity, double pricePerHour) {
        if (isFilledIn(name) && isFilledIn(capacity) && isFilledIn(pricePerHour) &&isFilledIn(division)) {
            this.name = name;
            this.division = division;
            this.capacity = capacity;
            this.pricePerHour = pricePerHour;
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

    public boolean isFilledIn(Object data) {
        return data != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
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
