package com.khaannn.couchbase.repository;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by khaannn on 3/31/2016.
 */
@Document
public class Comment {
    @Id
    private String commentId;

    @Field
    private String userId;


    @Field
    private Date date;

    @Field
    private String comment;

    @Field
    private ArrayList<Comment> commentReplies;

    public Comment(){
        this.commentId =  UUID.randomUUID().toString();
    }

    public Comment(String userId, Date date, String comment, ArrayList<Comment> commentReplies) {
        this.userId = userId;
        this.date = date;
        this.comment = comment;
        this.commentReplies = commentReplies;
        this.commentId =  UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ArrayList<Comment> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(ArrayList<Comment> commentReplies) {
        this.commentReplies = commentReplies;
    }
}