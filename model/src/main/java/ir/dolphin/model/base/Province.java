package ir.dolphin.model.base;

/**
 * @author Rafiee.Amin
 */


import ir.dolphin.model.BaseStaticEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @EntityName استانها
 */


@Entity
@Table(name = "PROVINCE", schema = "dbo")
@NamedQueries({
        @NamedQuery(name = "Sale.findAll", query = "SELECT sallerProfile FROM Profile sallerProfile")
})
public class Province implements Serializable, BaseStaticEntity {

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
    @Column(name = "NAME", length = 30, nullable = false)
    private String cityName;

    /**
     * @AttributeName نام انگلیسی شهر
     */
    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "ENAME", length = 30, nullable = false)
    private String lastName;


    /**
     * @AttributeName تصویر
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMAGE", nullable = false)
    private String image;

    /**
     * @AttributeName کد
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTCOD", nullable = false)
    private String postCod;


}
