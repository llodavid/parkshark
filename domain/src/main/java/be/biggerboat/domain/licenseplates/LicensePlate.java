package be.biggerboat.domain.licenseplates;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "LICENSE_PLATES")
public class LicensePlate {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "LICENSE_PLATE")
    private String plateNumber;


    @Column(name = "ISSUING_COUNTRY")
    private String issuingCountry;

    public LicensePlate() {
    }

    public LicensePlate(String plateNumber, String issuingCountry) {
        this.plateNumber = plateNumber;
        this.issuingCountry = issuingCountry;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
