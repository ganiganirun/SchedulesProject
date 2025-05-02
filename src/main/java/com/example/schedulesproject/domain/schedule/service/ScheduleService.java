package com.example.schedulesproject.domain.schedule.service;

import com.example.schedulesproject.domain.comment.dto.response.CommentResponseDto.Get;
import com.example.schedulesproject.domain.comment.repository.CommentRepository;
import com.example.schedulesproject.domain.schedule.dto.request.ScheduleRequestDto;
import com.example.schedulesproject.domain.schedule.dto.request.ScheduleRequestDto.Update;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto.All;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto.Single;
import com.example.schedulesproject.domain.schedule.entity.Schedule;
import com.example.schedulesproject.domain.schedule.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public ScheduleResponseDto.Add save(ScheduleRequestDto.Add requestDto) {

        Schedule schedule = Schedule.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writerId(requestDto.getWriterId())
                .build();

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto.Add(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getCreatedAt()
        );
    }


    @Transactional(readOnly = true)
    public Page<ScheduleResponseDto.All> findAll(Pageable pageable) {

        Page<Schedule> schedulesPage = scheduleRepository.findAll(pageable);

        List<Long> scheduleIdList = schedulesPage.stream().map(schedule -> schedule.getId()).toList();

        return schedulesPage
                .map(schedule ->
                        new All(
                                schedule.getWriterId(),
                                schedule.getTitle(),
                                schedule.getUpdatedAt(),
                                commentRepository.countByScheduleId(schedule.getId())

                        ));

    }

    public ScheduleResponseDto.Single findById(Long scheduleId) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        List<Get> commentList = commentRepository.findAllByScheduleIdOrderByCreatedAtAsc(scheduleId)
                .stream().map(comment -> new Get(comment.getId(), comment.getWriterId(),
                        comment.getContent(), comment.getCreatedAt())).toList();

        return new Single(
                findSchedule.getWriterId(),
                findSchedule.getTitle(),
                findSchedule.getContent(),
                findSchedule.getUpdatedAt(),
                commentList
        );
    }

    @Transactional
    public ScheduleResponseDto.Update updateSchedule(Long scheduleId, Update requestDto) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        findSchedule.updateSchedule(requestDto.getTitle(), requestDto.getContent());

        return new ScheduleResponseDto.Update(
                findSchedule.getWriterId(),
                findSchedule.getTitle(),
                findSchedule.getContent(),
                findSchedule.getUpdatedAt()
        );

    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        scheduleRepository.delete(findSchedule);
    }
}
