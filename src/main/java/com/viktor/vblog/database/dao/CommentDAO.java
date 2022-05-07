package com.viktor.vblog.database.dao;

import com.viktor.vblog.database.entity.Comment;

public class CommentDAO extends AbstractDAO<Comment> {

    public CommentDAO() {
        super(Comment.class);
    }
}