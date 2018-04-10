package be.biggerboat.domain.licenseplates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "LICENSE_PLATES")
public class LicensePlate {

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
