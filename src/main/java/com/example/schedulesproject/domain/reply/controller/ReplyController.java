package com.example.schedulesproject.domain.reply.controller;

import com.example.schedulesproject.domain.reply.dto.request.ReplyRequestDto;
import com.example.schedulesproject.domain.reply.dto.response.ReplyResponseDto;
import com.example.schedulesproject.domain.reply.dto.response.ReplyResponseDto.Add;
import com.example.schedulesproject.domain.reply.dto.response.ReplyResponseDto.Update;
import com.example.schedulesproject.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/api/schedules/{scheduleId}/comments/{commentId}/reply")
    public ResponseEntity<ReplyResponseDto.Add> createReply(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId,
            @RequestBody ReplyRequestDto.Add requestDto){

        Add reply = replyService.createReply(scheduleId, commentId, requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(reply);
    }

    @PatchMapping("/api/reply/{replyId}")
    public ResponseEntity<ReplyResponseDto.Update> updateReply(
            @PathVariable Long replyId,
            @RequestBody ReplyResponseDto.Update requestDto
    ){

        Update updateReply = replyService.updateReply(replyId, requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updateReply);
    }

    @DeleteMapping("/api/reply/{replyId}")
    public ResponseEntity<String> deleteReply(
            @PathVariable Long replyId
    ){
        replyService.deleteReply(replyId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("대댓글이 삭제가 완료되었습니다.");
    }



}
