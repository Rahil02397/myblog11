package com.myblog.moblog11.repository;

import com.myblog.moblog11.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
