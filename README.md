# SchedulesProject

## 요구사항
1. 댓글에 답급(대댓글)을 작성할 수 있습니다.
   - 대댓글은 부모 댓글(parentComment)과 연관관계를 가집니다.
2. 대댓글은 1 Depth 까지만 허용합니다.
   - 즉, 대댓글에 다시 대댓글은 불가능 합니다.
3. 대댓글도 댓글과 동일한 필드를 가집니다.
   - 댓글 내용(content), 작성일(createdAt), 수정일(updatedAt), 작성자ID(writerId), 일정ID(scheduleId), 부모댓글ID(parentCommentId)
4. 대댓글 조회 시, 부모 댓글 하위에 정렬되어 함께 조회됩니다.
   - 부모 댓글 -> 대댓글 순으로 정렬

## API
