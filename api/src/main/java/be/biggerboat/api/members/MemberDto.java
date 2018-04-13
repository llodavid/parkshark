package be.biggerboat.api.members;

import be.biggerboat.api.addresses.AddressDto;
import be.biggerboat.api.licenseplates.LicensePlateDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberDto {

    public int memberId;
    public String memberFirstName;
    public String memberLastName;
    public String memberEmail;
    public String phoneNumber;
    public AddressDto address;
    public LocalDate registrationDate;
    public List<LicensePlateDto> licensePlates;


    public MemberDto() {
    }


    public MemberDto withMemberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public MemberDto withMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
        return this;
    }

    public MemberDto withMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
        return this;
    }

    public MemberDto withMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
        return this;
    }

    public MemberDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MemberDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public MemberDto withLicensePlates(List<LicensePlateDto> licensePlates) {
        this.licensePlates = licensePlates;
        return this;
    }

    public MemberDto withRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

}