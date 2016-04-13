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

public class Comment {

    private String commentId;

    private String userId;



    private Date date;


    private String comment;


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

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", commentReplies=" + commentReplies +
                '}';
    }

}