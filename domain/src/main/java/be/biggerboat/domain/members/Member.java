package be.biggerboat.domain.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FK_MEMBER_ID")
    private List<LicensePlate> licensePlates;

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
        this.licensePlates = memberBuilder.licensePlates;
        this.registrationDate = LocalDate.now();
    }

    public void addLicensePlate(LicensePlate licensePlate) {
        licensePlates.add(licensePlate);
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

    public List<LicensePlate> getLicensePlate() {
        return licensePlates;
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
                //", licensePlate=" + licensePlates + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId &&
                Objects.equals(memberFirstName, member.memberFirstName) &&
                Objects.equals(memberLastName, member.memberLastName) &&
                Objects.equals(memberEmail, member.memberEmail) &&
                Objects.equals(phoneNumber, member.phoneNumber)&&
                Objects.equals(address, member.address) &&
                Objects.equals(registrationDate, member.registrationDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(memberId, memberFirstName, memberLastName, memberEmail, phoneNumber, address, registrationDate);
    }

    public static class MemberBuilder {
        private String memberFirstName;
        private String memberLastName;
        private String memberEmail;
        private String phoneNumber;
        private Address address;
        private List<LicensePlate> licensePlates;
        private LocalDate registrationDate;

        private boolean allFieldSet() {
            return (isFilledIn(memberFirstName)
                    && isFilledIn(memberLastName)
                    && (isFilledIn(memberEmail)
                    || isFilledIn(phoneNumber))
                    && address != null
                    && licensePlates != null
            );
        }

        public MemberBuilder() {
            licensePlates = new ArrayList<>();
        }

        private boolean isFilledIn(String field) {
            return field != null && !field.trim().equals("");
        }

        public MemberBuilder withMemberFirstName(String memberFirstName) {
            this.memberFirstName = memberFirstName;
            return this;
        }

        public MemberBuilder withMemberLastName(String memberLastName) {
            this.memberLastName = memberLastName;
            return this;
        }

        public MemberBuilder withMemberEmail(String memberEmail) {
            this.memberEmail = memberEmail;
            return this;
        }

        public MemberBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public MemberBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public MemberBuilder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlates.add(licensePlate);
            return this;
        }

        public MemberBuilder withLicensePlates(List<LicensePlate> licensePlates) {
            this.licensePlates = licensePlates;
            return this;
        }

        public MemberBuilder withRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Member build() {
            if (allFieldSet()) {
                return new Member(this);
            }
            throw new ParksharkException("Please provide all the necessary arguments.");
        }
    }
}
