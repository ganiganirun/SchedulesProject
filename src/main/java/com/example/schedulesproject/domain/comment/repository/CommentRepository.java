package com.example.schedulesproject.domain.comment.repository;

import com.example.schedulesproject.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    default Comment findByIdOrElseThrow(Long commentId){
        return findById(commentId).orElseThrow(()->
                new IllegalArgumentException("해당 댓글은 존재하지 않습니다."));
    }
}
