package be.biggerboat.domain.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBERS")
public class Member {

    @Id
    @SequenceGenerator(name = "member_seq", sequenceName = "member_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @Column(name = "MEMBER_ID")
    private int memberId;

    @Column(name = "FIRSTNAME")
    private String memberFirstName;

    @Column(name = "LASTNAME")
    private String memberLastName;

    @Column(name = "EMAIL")
    private String memberEmail;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Embedded
    private Address address;

    @Embedded
    private LicensePlate licensePlate;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    public Member() {
    }

    public Member(MemberBuilder memberBuilder) {
        this.memberFirstName = memberBuilder.memberFirstName;
        this.memberLastName = memberBuilder.memberLastName;
        this.memberEmail = memberBuilder.memberEmail;
        this.phoneNumber = memberBuilder.phoneNumber;
        this.address = memberBuilder.address;
        this.licensePlate = memberBuilder.licensePlate;
        this.registrationDate = memberBuilder.registrationDate;
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

    public Address getAddress() {
        return address;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberFirstName='" + memberFirstName + '\'' +
                ", memberLastName='" + memberLastName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address + '\'' +
                ", licensePlate=" + licensePlate + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public static class MemberBuilder{
        private String memberFirstName;
        private String memberLastName;
        private String memberEmail;
        private String phoneNumber;
        private Address address;
        private LicensePlate licensePlate;
        private LocalDate registrationDate;

        private boolean allFieldSet(){
            return(isFilledIn(memberFirstName)
                    && isFilledIn(memberLastName)
                    && (isFilledIn(memberEmail)
                        || isFilledIn(phoneNumber))
                    && address != null
                    //&& licensePlate != null
                    );
        }

        private boolean isFilledIn(String field){
            return field != null && !field.trim().equals("");
        }

        public MemberBuilder withMemberFirstName(String memberFirstName){
            this.memberFirstName = memberFirstName;
            return this;
        }

        public MemberBuilder withMemberLastName(String memberLastName){
            this.memberLastName = memberLastName;
            return this;
        }

        public MemberBuilder withMemberEmail(String memberEmail){
            this.memberEmail = memberEmail;
            return this;
        }

        public MemberBuilder withPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public MemberBuilder withAddress(Address address){
            this.address = address;
            return this;
        }

        public MemberBuilder withLicensePlate(LicensePlate licensePlate){
            this.licensePlate = licensePlate;
            return this;
        }

        public MemberBuilder withRegistrationDate(LocalDate registrationDate){
            this.registrationDate = registrationDate;
            return this;
        }

        public Member build(){
            if (allFieldSet()) {
                return new Member(this);
            }
            throw new ParksharkException("Please provide all the necessary arguments.");
        }
    }
}
