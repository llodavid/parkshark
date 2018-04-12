package be.biggerboat.api.licenseplates;

import be.biggerboat.domain.licenseplates.LicensePlate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class LicensePlateMapper {

    @Autowired
    public LicensePlateMapper() {
    }

    public LicensePlateDto toDto(LicensePlate licensePlate) {
        return new LicensePlateDto()
                .withPlateNumber(licensePlate.getPlateNumber())
                .withIssuingCountry(licensePlate.getIssuingCountry());
    }

    public LicensePlate toDomain(LicensePlateDto licensePlateDto) {
        return new LicensePlate(licensePlateDto.plateNumber, licensePlateDto.issuingCountry);
    }

}
