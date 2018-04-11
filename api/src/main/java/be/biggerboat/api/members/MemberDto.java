package be.biggerboat.api.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.time.LocalDate;

public class MemberDto {
    private String memberId;
    private String memberFirstName;
    private String memberLastName;
    private String memberEmail;
    private String phoneNumber;
    private Address address;
    private LicensePlate licensePlate;
    private LocalDate registrationDate;

    public MemberDto() {
    }


    public String getMemberId() {
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

    public Address getAddress() {
        return address;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MemberDto withMemberId(String memberId) {
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

    public MemberDto withAddress(Address address) {
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