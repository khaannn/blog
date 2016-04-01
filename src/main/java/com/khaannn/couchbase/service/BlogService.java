package com.khaannn.couchbase.service;

import com.khaannn.couchbase.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        postRepository.deleteAll();
        Post post = new Post();
        post.setTitle("Test Title");
        post.setUserName("Jeff");
        post.setPostText("<p>Test of Couchbase and Spring Data</p><p>Going to need markdown javascript</p>");
        post.setComments(new ArrayList<Comment>());
        post = postRepository.save(post);
    }

    public void createUser(String userName, int securityLevel, String password){
        User user = new User(userName, securityLevel, password);
        userRepository.save(user);
    }


}
