package com.viktor.vblog.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "role_name")
    private String roleName;
}