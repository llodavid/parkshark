package be.biggerboat.api.licenseplates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Objects;

@Named
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlateDto that = (LicensePlateDto) o;
        return Objects.equals(plateNumber, that.plateNumber) &&
                Objects.equals(issuingCountry, that.issuingCountry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(plateNumber, issuingCountry);
    }
}
