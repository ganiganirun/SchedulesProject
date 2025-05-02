package com.example.schedulesproject.domain.schedule.dto.response;

import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ScheduleResponseDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add{

        private Long id;

        private String title;

        private String content;

        private LocalDateTime createdAt;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class All{

        private Long writerId;

        private String title;

        private LocalDateTime updatedAt;

        private Long countComment;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Single{

        private Long writerId;

        private String title;

        private String content;

        private LocalDateTime updatedAt;

        private List<CommentResponseDto.Get> commentList;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update{

        private Long writerId;

        private String title;

        private String content;

        private LocalDateTime updatedAt;

    }



}
