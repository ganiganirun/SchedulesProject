package com.example.schedulesproject.domain.schedule.repository;

import com.example.schedulesproject.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


    default Schedule findByIdOrElseThrow(Long scheduleId){
        return findById(scheduleId).orElseThrow(()-> new IllegalArgumentException("해당 스케줄을 찾을 수 없습니다."));
    };
}
