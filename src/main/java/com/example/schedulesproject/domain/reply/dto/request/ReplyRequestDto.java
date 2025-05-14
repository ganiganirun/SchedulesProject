package com.example.schedulesproject.domain.reply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReplyRequestDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Add{

        private String content;

        private Long writerId;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{

        private String content;
    }

}
