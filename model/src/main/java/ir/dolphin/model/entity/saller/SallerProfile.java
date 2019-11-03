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
        @NamedQuery(name = "SallerProfile.findByNationalCode", query = "SELECT sallerProfile FROM SallerProfile sallerProfile where sallerProfile.nationalCode =:nationalCode")
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

    @Column(name = "FIRST_NAME", columnDefinition = "nvarchar(30)", nullable = false)
    private String firstName;

    /**
     *
     * @AttributeName نام خانوادگی
     */

    @Column( name = "LAST_NAME",columnDefinition = "nvarchar(30)", nullable = false  )
    private String lastName;


    /**
     *
     * @AttributeName وضعیت فعالیت
     * @AttributeType YesNo
     */

    @Column(name = "ACTIVE", nullable = false)
    private Short active;

    /**
     *
     * @AttributeName کدملی
     */

    @Column(name = "NATIONAL_CODE", nullable = false,length = 10)
    private String nationalCode;

    /**
     *
     * @AttributeName شماره تماس
     */

    private String phone;

    /**
     *
     * @AttributeName شماره حساب
     */

    @Column(name = "ACC_NUMBER", nullable = true)
    private String accountNumber;

    /**
     *
     * @AttributeName نام پدر
     */

    @Column(name = "FATHER_NAME",  columnDefinition = "nvarchar(30)" ,nullable = true)
    private String fatherName;

    /**
     *
     * @AttributeName کدپرسنلی
     */

    @Column(name = "PERSONAL_NUMBER", nullable = true)
    private Integer personalNumber;


    //ToDo تعریف مقاطع تحصیلی بعنوان یک ثابت
    /**
     *
     * @AttributeName مقطع تحصیلی
     */

    @Column(name = "SCIENCE_DEGREE", nullable = true)
    private Short scienceDegree;

    /**
     *
     * @AttributeName شماره شناسنامه
     */

    @Column(name = "IDENTITY_NUMBER", nullable = true)
     private BigDecimal identityNumber;


    //ToDO تعریف جدول شهر و استان و ارتباط آن
    /**
     *
     * @AttributeName محل تولد
     */

    @Column(name = "BIRTHPLACE", nullable = false)
    private Short birthPlace;


    /**
     *
     * @AttributeName تاریخ تولد
     */

    @Column(name = "BIRTH_DATE", nullable = false)
    private Integer birthDate;



    
    /**
     *
     * @AttributeName وضعیت تاهل
     */
//    @Basic(optional = false)
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 1)
    @Column(name = "MARITAL_STATUS", nullable = false)
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

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
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
