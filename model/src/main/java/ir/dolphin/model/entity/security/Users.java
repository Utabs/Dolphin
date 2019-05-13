package ir.dolphin.model.entity.security;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Email", length = 80)
    private String email;

    @Column(name = "First_Name", length = 50
            , columnDefinition = "NVARCHAR(50)")
    private String firstName;

    @Column(name = "Last_Name", length = 50
            , columnDefinition = "NVARCHAR(50)")
    private String lastName;

    @Column(name = "UserName", length = 20)
    @NotNull
    private String userName;

    @Column(name = "Password", length = 20)
    @NotNull
    private String password;

    @Column(name = "Enable", columnDefinition = "int default 1")
    private Integer enable;

    @OneToMany
    private Set<Role> roles;


}
