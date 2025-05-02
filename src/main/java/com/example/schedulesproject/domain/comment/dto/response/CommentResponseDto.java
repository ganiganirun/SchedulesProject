package com.example.schedulesproject.domain.comment.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class CommentResponseDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Add{

        private Long id;

        private Long writerId;

        private String content;

        private LocalDateTime createdAt;

        private Long scheduleId;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{

        private Long id;

        private Long writerId;

        private String content;

        private LocalDateTime updatedAt;

        private Long scheduleId;
    }

}
