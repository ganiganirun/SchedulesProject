package com.example.schedulesproject.domain.reply.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReplyResponseDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Add{

        private Long id;

        private Long writerId;

        private String content;

        private LocalDateTime createdAt;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Get{

        private Long id;

        private Long writerId;

        private String content;

        private LocalDateTime createdAt;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{

        private Long id;

        private Long writerId;

        private String content;

        private LocalDateTime updatedAt;
    }

}
