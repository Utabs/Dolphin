package ir.dolphin.model.entity.saller;


/**
 * @author askari.abbas
 */


import ir.dolphin.model.BaseStaticEntity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @EntityName پروفایل فروشنده
 */


@Entity
@Table(name = "SALLER_PROFILE", schema = "dbo")
@NamedQueries({
        @NamedQuery(name = "SallerProfile.findAll", query = "SELECT sallerProfile FROM SallerProfile sallerProfile")
})

public class SallerProfile  implements Serializable, BaseStaticEntity {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @AttributeName شناسه
     */
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     * @AttributeName نام
     */
//    @Basic(optional = false)
//    @NotNull
//    @Size(max = 30)
//    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;

    /**
     *
     * @AttributeName نام خانوادگی
     */
//    @Basic(optional = false)
//    @NotNull
//    @Size(max = 30)
//    @Column(name = "LAST_NAME", length = 30, nullable = false )
    private String lastName;


    /**
     *
     * @AttributeName وضعیت فعالیت
     * @AttributeType YesNo
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
//    @Column(name = "ACTIVE", nullable = false)
    private Short active;

    /**
     *
     * @AttributeName کدملی
     */
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    /**
     *
     * @AttributeName شماره تماس
     */
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "PHONE", nullable = false)
    private String phone;

    /**
     *
     * @AttributeName شماره حساب
     */
//    @Basic(optional = true)
//    @Size(max = 20)
//    @Column(name = "ACC_NUMBER", nullable = true)
    private String accountNumber;

    /**
     *
     * @AttributeName نام پدر
     */
//    @Basic(optional = true)
//    @Size(max = 30)
//    @Column(name = "FATHER_NAME", nullable = true)
    private String fatherName;

    /**
     *
     * @AttributeName کدپرسنلی
     */
//    @Basic(optional = true)
//    @Size(max = 30)
//    @Column(name = "PERSONAL_NUMBER", nullable = true)
    private Integer personalNumber;


    //ToDo تعریف مقاطع تحصیلی بعنوان یک ثابت
    /**
     *
     * @AttributeName مقطع تحصیلی
     */
//    @Basic(optional = true)
//    @Min(value = 0)
//    @Max(value = 10)
//    @Column(name = "SCIENCE_DEGREE", nullable = true)
    private Short scienceDegree;

    /**
     *
     * @AttributeName شماره شناسنامه
     */
//    @Basic(optional = true)
//    @Size(max = 15)
//    @Column(name = "IDENTITY_NUMBER", nullable = true)
//    @DecimalMax("30000.00")
    private BigDecimal identityNumber;


    //ToDO تعریف جدول شهر و استان و ارتباط آن
    /**
     *
     * @AttributeName محل تولد
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
//    @Column(name = "BIRTHPLACE", nullable = false)
    private Short birthPlace;


    /**
     *
     * @AttributeName تاریخ تولد
     */
//    @Basic(optional = false)
//    @NotNull
//    @Size(max = 8,min = 8)
//    @Column(name = "BIRTH_DATE", nullable = false)
    private Short birthDate;



    
    /**
     *
     * @AttributeName وضعیت تاهل
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
//    @Column(name = "MARITAL_STATUS", nullable = false)
    private Short maritalStatus;


    /**
     *
     * @AttributeName جنسیت
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
//    @Column(name = "SEXUALITY", nullable = false)
    private Short sexuality;


    /**
     *
     * @AttributeName کد بیمه
     */
//    @Basic(optional = false)
//    @NotNull
//    @Size(max = 20)
//    @Column(name = "INSURANCE_COD", nullable = false)
    private String insuranceCod;



    //ToDo از چه جنسی باشد
    /**
     *
     * @AttributeName مدارک
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
//    @Column(name = "ASSETS", nullable = false)
    private Short assets;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
