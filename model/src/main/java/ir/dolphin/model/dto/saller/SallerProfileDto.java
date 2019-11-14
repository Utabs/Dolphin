package ir.dolphin.model.dto.saller;


/**
 * @author amin.rafiee
 */


import ir.dolphin.model.BaseStaticEntity;

import java.math.BigDecimal;

/**
 *
 * @EntityName پروفایل فروشنده
 */

public class SallerProfileDto implements BaseStaticEntity {

    private String firstName;
    private String lastName;
    private Short active;
    private String nationalCode;
    private String phone;
    private String accountNumber;
    private String fatherName;
    private Integer personalNumber;
    private Short scienceDegree;
    private BigDecimal identityNumber;
    private Short birthPlace;
    private Short birthDate;
    private Short maritalStatus;
    private Short sexuality;
    private String insuranceCod;
    private Short assets;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Short getScienceDegree() {
        return scienceDegree;
    }

    public void setScienceDegree(Short scienceDegree) {
        this.scienceDegree = scienceDegree;
    }

    public BigDecimal getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(BigDecimal identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Short getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Short birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Short getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Short birthDate) {
        this.birthDate = birthDate;
    }

    public Short getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Short maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Short getSexuality() {
        return sexuality;
    }

    public void setSexuality(Short sexuality) {
        this.sexuality = sexuality;
    }

    public String getInsuranceCod() {
        return insuranceCod;
    }

    public void setInsuranceCod(String insuranceCod) {
        this.insuranceCod = insuranceCod;
    }

    public Short getAssets() {
        return assets;
    }

    public void setAssets(Short assets) {
        this.assets = assets;
    }
}
