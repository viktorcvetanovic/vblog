package com.viktor.vblog.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles=new HashSet<>();
}
