package ir.dolphin.model.entity.employee;



import ir.dolphin.model.BaseStaticEntity;
import ir.dolphin.model.entity.shop.ShopTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @EntityName پروفایل فروشنده
 */


@Entity
@Table(name = "TimeSheetProfile", schema = "dbo")
@NamedQueries({
 })

public class TimeSheetTO implements Serializable, BaseStaticEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SystemRegTime")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date systemRegTime;

    @Column(name = "CurrentRegTime")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date currentRegisterTime;

    @Column(name = "RegType", length = 1)
    @NotNull
    private String regType;

    @Column(name = "Latitude")
    @NotNull
    private BigDecimal latitude;

    @Column(name = "Longitude")
    @NotNull
    private BigDecimal longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Shop_id")
    private ShopTO shop;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee_id")
    private EmployeeProfile employee;


}

