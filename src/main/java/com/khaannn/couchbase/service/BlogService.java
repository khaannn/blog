package com.khaannn.couchbase.service;

import com.khaannn.couchbase.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chatham_j on 4/1/2016.
 */
@Service
public class BlogService {


    private final UserRepository userRepository;
    private final PostRepository postRepository;



    @Autowired
    public BlogService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void insertPost(Post post){
        postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.getAllPosts();
    }

    public void doStuff(){
        Post post = new Post();
        post.setTitle("Test Title");
        post.setDescription("Desription");
        post.setUserName("Jeff");
        post.setPostText("<p>Test of Couchbase and Spring Data</p><p>Going to need markdown javascript</p>");
        Comment comment = new Comment("Khaannn", new Date(), "first post", new ArrayList<>());
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(comment);
        post.setComments(comments);
        post = postRepository.save(post);
    }

    public void createUser(String userName, int securityLevel, String password){
        User user = new User(userName, securityLevel, password);
        userRepository.save(user);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }





}
