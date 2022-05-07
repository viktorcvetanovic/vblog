package com.viktor.vblog.database.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tag")
@Data
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long idTag;

    @Column(name = "tag_name")
    private String name;
}