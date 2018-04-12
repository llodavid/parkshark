package be.biggerboat.service.members;

import be.biggerboat.domain.members.Member;

import javax.inject.Named;

@Named
public class MemberValidator   {

    public boolean isValidForCreation(Member member) {
        return !isAFieldEmptyOrNull(member) && member.getMemberId() == 0;
    }

    protected boolean isNull(Object object) {
        return object == null;
    }

    protected boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    protected boolean isAFieldEmptyOrNull(Member member) {

        return isNull(member)
                || isEmptyOrNull(member.getMemberFirstName())
                || isEmptyOrNull(member.getMemberLastName())
                || isNull(member.getAddress())
                || isEmptyOrNull(member.getAddress().getHousenumber())
                || isEmptyOrNull(member.getAddress().getStreet())
                || isEmptyOrNull(member.getAddress().getCountry())
                || isNull(member.getMemberEmail())
                || isNull(member.getPhoneNumber())
                || isNull(member.getLicensePlate())
                || isNull(member.getRegistrationDate());
    }

    public void throwInvalidStateException(Member member, String type) {
        throw new IllegalStateException("Invalid " + (member == null ? "NULL_ENTITY" : member.getClass().getSimpleName())
                + " provided for " + type + ". Provided object: " + (member == null ? null : member.toString()));
    }

}
