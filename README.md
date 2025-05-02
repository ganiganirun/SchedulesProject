# SchedulesProject

## 요구사항
1. 생성한 일정에 댓글을 남길 수 있다.
   - 댓글과 일정은 연간관계를 가진다.
2. 댓글을 저장, 조회, 수정, 삭제 할 수 있다.
3. 댓글은 아래와 같은 필드를 가진다.
   - 댓글 내용(content) , 작성일(createdAt), 수정일(updatedAt), 작성자ID(writerId), 일저ID(scheduleId)
   - 작성일, 수정일 필드는 JPA Auditing을 활용하여 적용한다.



## API
