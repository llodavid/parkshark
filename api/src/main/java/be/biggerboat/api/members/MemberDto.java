package be.biggerboat.api.members;

import be.biggerboat.api.addresses.AddressDto;
import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.time.LocalDate;

public class MemberDto {
    public int memberId;
    public String memberFirstName;
    public String memberLastName;
    public String memberEmail;
    public String phoneNumber;
    public AddressDto address;
    public LocalDate registrationDate;

    public LicensePlate licensePlate;

    public String plateNumber;
    public String issuingCountry;


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

    MemberDto withLicensePlate(LicensePlate licensePlate) {
        this.plateNumber = licensePlate.getPlateNumber();
        this.issuingCountry = licensePlate.getIssuingCountry();
        return this;
    }

    public MemberDto withRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

}