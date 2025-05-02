package com.example.schedulesproject.domain.comment.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add{

        @NotBlank(message = "내용을 입력해주세요.")
        private String content;

        @Positive(message = "작성자 id는 양의 정수만을 입력 받습니다.")
        @NotNull(message = "작성자 id를 입력해주세요.")
        private Long writerId;

    }

}
