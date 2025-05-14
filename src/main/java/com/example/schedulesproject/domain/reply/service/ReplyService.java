package com.example.schedulesproject.domain.reply.service;

import com.example.schedulesproject.domain.comment.entity.Comment;
import com.example.schedulesproject.domain.comment.repository.CommentRepository;
import com.example.schedulesproject.domain.reply.dto.request.ReplyRequestDto.Add;
import com.example.schedulesproject.domain.reply.dto.response.ReplyResponseDto;
import com.example.schedulesproject.domain.reply.dto.response.ReplyResponseDto.Update;
import com.example.schedulesproject.domain.reply.entity.Reply;
import com.example.schedulesproject.domain.reply.repository.ReplyRepository;
import com.example.schedulesproject.domain.schedule.entity.Schedule;
import com.example.schedulesproject.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final CommentRepository commentRepository;

    private final ScheduleRepository scheduleRepository;

    private final ReplyRepository replyRepository;

    public ReplyResponseDto.Add createReply(Long scheduleId, Long commentId, Add requestDto) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment findComment = commentRepository.findByIdOrElseThrow(commentId);

        Reply reply = Reply.builder()
                .content(requestDto.getContent())
                .writerId(requestDto.getWriterId())
                .schedule(findSchedule)
                .comment(findComment)
                .build();

        Reply saveReply = replyRepository.save(reply);

        return new ReplyResponseDto.Add(
                saveReply.getId(),
                saveReply.getWriterId(),
                saveReply.getContent(),
                saveReply.getCreatedAt()
        );

    }

    @Transactional
    public ReplyResponseDto.Update updateReply(Long replyId, Update requestDto) {

        Reply findReply = replyRepository.findByIdOrElesThrow(replyId);

        findReply.UpdateReply(requestDto.getContent());

        return new ReplyResponseDto.Update(
                findReply.getId(),
                findReply.getWriterId(),
                findReply.getContent(),
                findReply.getUpdatedAt()
        );
    }

    public void deleteReply(Long replyId) {

        Reply findReply = replyRepository.findByIdOrElesThrow(replyId);

        replyRepository.delete(findReply);
    }
}
