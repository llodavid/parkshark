package be.biggerboat.api.members;

import be.biggerboat.api.addresses.AddressDto;
import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.time.LocalDate;

public class MemberDto {
    private int memberId;
    private String memberFirstName;
    private String memberLastName;
    private String memberEmail;
    private String phoneNumber;
    private AddressDto address;
    private LocalDate registrationDate;

    private LicensePlate licensePlate;

    private String plateNumber;
    private String issuingCountry;


    public MemberDto() {
    }


    public int getMemberId() {
        return memberId;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressDto getAddress() {
        return address;
    }

    public LicensePlate getLicensePlate() {
        return new LicensePlate(plateNumber, issuingCountry);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    MemberDto withLicensePlates(LicensePlate licensePlate) {
        this.plateNumber = licensePlate.getPlateNumber();
        this.issuingCountry = licensePlate.getIssuingCountry();
        return this;
    }


    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
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

    public MemberDto withLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public MemberDto withRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

}