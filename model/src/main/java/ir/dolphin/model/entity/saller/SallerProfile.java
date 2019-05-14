/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.dolphin.model.entity.saller;


/**
 * @author askari.abbas
 */

import com.sun.javafx.geom.Path2D;
import ir.dolphin.model.BaseStaticEntity;
import org.hibernate.validator.constraints.Length;
import sun.util.resources.cldr.vai.CalendarData_vai_Latn_LR;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

public class SallerProfile implements Serializable, BaseStaticEntity {

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
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;

    /**
     *
     * @AttributeName نام خانوادگی
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;


    /**
     *
     * @AttributeName وضعیت فعالیت
     * @AttributeType YesNo
     */
    @Basic(optional = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "ACTIVE", nullable = false)
    private Short active;

    /**
     *
     * @AttributeName کدملی
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    /**
     *
     * @AttributeName شماره تماس
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONE", nullable = false)
    private String phone;

    /**
     *
     * @AttributeName شماره حساب
     */
    @Basic(optional = true)
    @Size(max = 20)
    @Column(name = "ACC_NUMBER", nullable = true)
    private String accountNumber;

    /**
     *
     * @AttributeName نام پدر
     */
    @Basic(optional = true)
    @Size(max = 30)
    @Column(name = "FATHER_NAME", nullable = true)
    private String fatherName;

    /**
     *
     * @AttributeName کدپرسنلی
     */
    @Basic(optional = true)
    @Size(max = 30)
    @Column(name = "PERSONAL_NUMBER", nullable = true)
    private Integer personalNumber;


    //ToDo تعریف مقاطع تحصیلی بعنوان یک ثابت
    /**
     *
     * @AttributeName مقطع تحصیلی
     */
    @Basic(optional = true)
    @Min(value = 0)
    @Max(value = 10)
    @Column(name = "SCIENCE_DEGREE", nullable = true)
    private Short scienceDegree;

    /**
     *
     * @AttributeName شماره شناسنامه
     */
    @Basic(optional = true)
    @Size(max = 15)
    @Column(name = "IDENTITY_NUMBER", nullable = true)
    private BigDecimal identityNumber;


    //ToDO تعریف جدول شهر و استان و ارتباط آن
    /**
     *
     * @AttributeName محل تولد
     */
    @Basic(optional = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "BIRTHPLACE", nullable = false)
    private Short birthPlace;


    /**
     *
     * @AttributeName تاریخ تولد
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 8,min = 8)
    @Column(name = "BIRTH_DATE", nullable = false)
    private Short birthDate;



    
    /**
     *
     * @AttributeName وضعیت تاهل
     */
    @Basic(optional = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "MARITAL_STATUS", nullable = false)
    private Short maritalStatus;


    /**
     *
     * @AttributeName جنسیت
     */
    @Basic(optional = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "SEXUALITY", nullable = false)
    private Short sexuality;


    /**
     *
     * @AttributeName کد بیمه
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "INSURANCE_COD", nullable = false)
    private String insuranceCod;



    //ToDo از چه جنسی باشد
    /**
     *
     * @AttributeName مدارک
     */
    @Basic(optional = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "ASSETS", nullable = false)
    private Short assets;


}
