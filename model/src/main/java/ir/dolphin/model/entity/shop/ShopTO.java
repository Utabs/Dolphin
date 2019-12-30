package ir.dolphin.model.entity.shop;


import ir.dolphin.model.BaseStaticEntity;
import ir.dolphin.model.entity.employee.TimeSheetTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Shop", schema = "dbo")
public class ShopTO implements Serializable, BaseStaticEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADDRESS", length = 80)
    @NotNull
    @Size(min = 4, max = 80)
    private String address;

    @Column(name = "LOCATION" )
    @NotNull
    private BigDecimal location;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TimeSheetTO> timeSheets=new HashSet<TimeSheetTO>();

}
