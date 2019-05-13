package ir.dolphin.model.entity.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Role", length = 20)
    @NotNull
    private String role;

    @Column(name = "Enable",columnDefinition = "int default 0")
    @NotNull
    private Integer active;

    @ManyToOne
    private Users users;





    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
