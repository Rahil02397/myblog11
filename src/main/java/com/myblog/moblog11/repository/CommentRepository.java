package com.myblog.moblog11.repository;

import com.myblog.moblog11.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
