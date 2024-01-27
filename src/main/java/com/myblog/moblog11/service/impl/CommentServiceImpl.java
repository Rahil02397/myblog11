package com.myblog.moblog11.service.impl;

import com.myblog.moblog11.entity.Comment;
import com.myblog.moblog11.entity.Post;
import com.myblog.moblog11.exception.ResourceNotFoundException;
import com.myblog.moblog11.payload.CommentDto;
import com.myblog.moblog11.repository.CommentRepository;
import com.myblog.moblog11.repository.PostRepository;
import com.myblog.moblog11.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;



    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id:" + postId)
        );

        Comment comment= new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());


        return dto;

    }

}
