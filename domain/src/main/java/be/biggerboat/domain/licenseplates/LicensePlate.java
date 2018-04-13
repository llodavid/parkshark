package be.biggerboat.domain.licenseplates;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "LICENSE_PLATES")
public class LicensePlate {

    @Id
    @SequenceGenerator(name = "license_plate_seq", sequenceName = "license_plate_id_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_plate_seq")
    @Column(name = "LICENSE_PLATE_ID")
    private int licenseId;

    @Column(name = "LICENSE_PLATE")
    private String plateNumber;

    @Column(name = "ISSUING_COUNTRY")
    private String issuingCountry;

    private LicensePlate() {
    }

    public LicensePlate(String plateNumber, String issuingCountry) {
        this.plateNumber = plateNumber;
        this.issuingCountry = issuingCountry;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
