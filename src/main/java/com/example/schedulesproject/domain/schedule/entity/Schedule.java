package com.example.schedulesproject.domain.schedule.entity;


import com.example.schedulesproject.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // schedule id

    @Column(nullable = false)
    private String title; // 일정 제목

    @Column(nullable = false)
    private String content; // 일정 내용

    @Column(nullable = false)
    private Long writerId; // 작성자 id

    @Builder
    public Schedule(String title, String content, Long writerId){
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }

    // schedule 수정
    public void updateSchedule(String title, String content){
        this.title = title;
        this.content = content;
    }



}
