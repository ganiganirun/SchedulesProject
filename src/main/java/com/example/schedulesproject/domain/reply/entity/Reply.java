package com.example.schedulesproject.domain.reply.entity;

import com.example.schedulesproject.domain.comment.entity.Comment;
import com.example.schedulesproject.domain.common.BaseEntity;
import com.example.schedulesproject.domain.schedule.entity.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long writerId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;


    @Builder
    public Reply(String content, Long writerId, Schedule schedule, Comment comment){
        this.content = content;
        this.writerId = writerId;
        this.schedule =schedule;
        this.comment = comment;
    }

    public void UpdateReply(String content){
        this.content = content;
    }

}
