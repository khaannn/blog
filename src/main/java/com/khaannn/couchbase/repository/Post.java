package com.khaannn.couchbase.repository;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by chatham_j on 3/31/2016.
 * http://guide.couchdb.org/draft/views.html
 * http://projects.spring.io/spring-data-couchbase/
 *
 */
@Document
public class Post {
    @Id
    private Date postDate;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private String postText;

    @Field
    private ArrayList<Comment> comments;

    @Field
    private String userName;

    public Post(){
        this.postDate = new Date();
    }

    public Post(String title, String description, String postText, ArrayList<Comment> comments, String userName){
        this.postDate = new Date();
        this.title = title;
        this.description = description;
        this.postText = postText;
        this.comments = comments;
        this.userName = userName;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postDate=" + postDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postText='" + postText + '\'' +
                ", comments=" + comments +
                ", userName='" + userName + '\'' +
                '}';
    }
}
