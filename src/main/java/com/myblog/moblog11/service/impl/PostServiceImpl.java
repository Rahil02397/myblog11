package com.myblog.moblog11.service.impl;

import com.myblog.moblog11.entity.Post;
import com.myblog.moblog11.payload.PostDto;
import com.myblog.moblog11.repository.PostRepository;
import com.myblog.moblog11.service.PostService;
import com.myblog.moblog11.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postdto) {
        Post post = new Post();
        post.setTitle(postdto.getTitle());
        post.setDescription(postdto.getDescription());
        post.setContent(postdto.getContent());
        Post savedPost = postRepository.save(post);

        PostDto dto=new PostDto();
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id:" + id)

        );
        PostDto dto=new PostDto();
        dto.setId(dto.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
}
