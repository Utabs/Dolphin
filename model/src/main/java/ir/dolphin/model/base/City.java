/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.dolphin.model.base;


/**
 * @author Rafiee.Amin
 */


import ir.dolphin.model.BaseStaticEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @EntityName شهرها
 */


@Entity
@Table(name = "CITY", schema = "dbo")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "SELECT sallerProfile FROM SallerProfile sallerProfile")
})

public class City implements Serializable, BaseStaticEntity {

    private static final long serialVersionUID = 1L;

    /**
     * @AttributeName شناسه
     */
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * @AttributeName نام شهر
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "CITY_NAME", length = 30, nullable = false)
    private String cityName;

    /**
     * @AttributeName نام انگلیسی
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "CITY_ENAME", length = 30, nullable = false)
    private String cityEname;


    /**
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
     * @AttributeName پیش شماره
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONE_COD", nullable = false)
    private String phoneCod;

}
