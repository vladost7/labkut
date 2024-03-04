package com.boots.repository;

import com.boots.entity.Post;
import com.boots.entity.Role;
import com.boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post getById(Long id);

}
