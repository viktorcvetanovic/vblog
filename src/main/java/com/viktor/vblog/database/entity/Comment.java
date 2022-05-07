package com.viktor.vblog.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long idComment;

    @Column(name = "id_post")
    private Long idPost;

    @Column(name = "body")
    private String body;

    @Column(name = "commenter_email")
    private String commenterEmail;

    @Column(name = "commenter_name")
    private String commenterName;

    @Column(name = "date_commented")
    private LocalDate dateCommented;
}