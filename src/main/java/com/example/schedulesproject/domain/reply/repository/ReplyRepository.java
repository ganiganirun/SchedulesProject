package com.example.schedulesproject.domain.reply.repository;

import com.example.schedulesproject.domain.reply.entity.Reply;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    default Reply findByIdOrElesThrow(Long id){
        return findById(id).orElseThrow(() -> new IllegalArgumentException("해당 대댓글을 찾을 수 없습니다."));
    }

    List<Reply> findAllByCommentIdOrderByCreatedAtAsc(Long commentId);

    List<Reply> findAllByScheduleId(Long scheduleId);

}
