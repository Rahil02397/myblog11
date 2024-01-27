package com.myblog.moblog11.service;

import com.myblog.moblog11.payload.CommentDto;

public interface CommentService {


    CommentDto createComment(CommentDto commentDto, long postId);
}

