package be.biggerboat.domain.licenseplates;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table
public class LicensePlate {
    private String plateNumber;
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
