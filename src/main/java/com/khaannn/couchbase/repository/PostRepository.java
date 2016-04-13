package com.khaannn.couchbase.repository;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chatham_j on 4/1/2016.
 */
public interface PostRepository extends CrudRepository<Post, String> {

        @View(designDocument = "post", viewName = "returnAll")
        List<Post> getAllPosts();


}
