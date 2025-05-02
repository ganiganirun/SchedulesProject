package com.example.schedulesproject.domain.comment.service;


import com.example.schedulesproject.domain.comment.dto.request.CommentRequestDto.Add;
import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto;
import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto.Update;
import com.example.schedulesproject.domain.comment.entity.Comment;
import com.example.schedulesproject.domain.comment.repository.CommentRepository;
import com.example.schedulesproject.domain.schedule.entity.Schedule;
import com.example.schedulesproject.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto.Add createComment(Long scheduleId, Add requestDto) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .writerId(requestDto.getWriterId())
                .schedule(findSchedule)
                .build();

        Comment saveComment = commentRepository.save(comment);

        return new CommentResponseDto.Add(
                saveComment.getId(),
                saveComment.getWriterId(),
                saveComment.getContent(),
                saveComment.getCreatedAt(),
                saveComment.getSchedule().getId()
        );
    }


    @Transactional(readOnly = true)
    public CommentResponseDto.Update findComment(Long commentId) {
        Comment findComment = commentRepository.findByIdOrElseThrow(commentId);

        return new CommentResponseDto.Update(
                findComment.getId(),
                findComment.getWriterId(),
                findComment.getContent(),
                findComment.getUpdatedAt(),
                findComment.getSchedule().getId()
        );

    }

    @Transactional
    public CommentResponseDto.Update updateComment(Long commentId, Add requestDto) {

        Comment findComment = commentRepository.findByIdOrElseThrow(commentId);

        findComment.updateComment(requestDto.getContent());

        return new Update(
                findComment.getId(),
                findComment.getWriterId(),
                findComment.getContent(),
                findComment.getUpdatedAt(),
                findComment.getSchedule().getId()
        );
    }

    @Transactional
    public void deleteComment(Long commentId) {

        Comment findComment = commentRepository.findByIdOrElseThrow(commentId);

        commentRepository.delete(findComment);

    }

}
