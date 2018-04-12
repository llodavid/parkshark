package be.biggerboat.api.licenseplates;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class LicensePlateDto {
    public String plateNumber;
    public String issuingCountry;

    public LicensePlateDto() {
    }



    public LicensePlateDto withPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public LicensePlateDto withIssuingCountry(String issuingCountry){
        this.issuingCountry = issuingCountry;
        return this;
    }



}
