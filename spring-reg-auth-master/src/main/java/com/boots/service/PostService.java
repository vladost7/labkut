package com.boots.service;

import com.boots.entity.Post;
import com.boots.entity.Role;
import com.boots.entity.User;
import com.boots.repository.PostRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public List<Post> allPosts(){
        List<Post> posts = postRepository.findAll();

        return posts;
    }

    public boolean deletePost(Long postId){
        if (postRepository.findById(postId).isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    public Post findPost(Long postId){
       return postRepository.getById(postId);
    }

    public void updatePost(Post post){
        User userFromDB = userRepository.findByUsername(post.getPostUser().getUsername());
        post.setPostUser(userFromDB);

        postRepository.save(post);
    }

    public boolean saveUser(Post post) {
        User userFromDB = userRepository.findByUsername(post.getPostUser().getUsername());

        if (userFromDB == null) {
            return false;
        }

        post.setPostUser(userFromDB);
        postRepository.save(post);
        return true;
    }
}
