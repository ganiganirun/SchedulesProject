package com.example.schedulesproject.domain.comment.repository;

import com.example.schedulesproject.domain.comment.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    default Comment findByIdOrElseThrow(Long commentId){
        return findById(commentId).orElseThrow(()->
                new IllegalArgumentException("해당 댓글은 존재하지 않습니다."));
    }

    Long countByScheduleId(Long scheduleId);

    List<Comment> findAllByScheduleIdOrderByCreatedAtAsc(Long scheduleId);
}
