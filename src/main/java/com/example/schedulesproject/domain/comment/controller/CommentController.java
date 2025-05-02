package com.example.schedulesproject.domain.comment.controller;

import com.example.schedulesproject.domain.comment.dto.request.CommentRequestDto;
import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto;
import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto.Add;
import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto.Update;
import com.example.schedulesproject.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponseDto.Add> createComment(
            @PathVariable Long scheduleId,
            @Valid @RequestBody CommentRequestDto.Add requestDto){

        Add saveComment = commentService.createComment(scheduleId, requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveComment);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto.Update> findComment(@PathVariable Long commentId){

        Update comment = commentService.findComment(commentId);

        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto.Update> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto.Add requestDto
    ){
        Update updateComment = commentService.updateComment(commentId, requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updateComment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId){

        commentService.deleteComment(commentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("댓글이 삭제되었습니다.");
    }

}
