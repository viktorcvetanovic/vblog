package com.viktor.vblog.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
@Data
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long idPost;

    @Column(name = "body")
    private String body;

    @Column(name = "excerpt")
    private String excerpt;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @Column(name = "date_posted")
    private LocalDate datePosted;

    @Column(name = "published")
    private Boolean published;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private User idUser;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "id_post"), inverseJoinColumns = @JoinColumn(name = "id_tag"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_post")
    private List<Comment> commentList = new ArrayList<>();
}