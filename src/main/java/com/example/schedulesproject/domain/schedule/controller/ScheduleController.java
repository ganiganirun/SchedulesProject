package com.example.schedulesproject.domain.schedule.controller;

import com.example.schedulesproject.domain.schedule.dto.request.ScheduleRequestDto;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto.All;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto.Single;
import com.example.schedulesproject.domain.schedule.dto.response.ScheduleResponseDto.Update;
import com.example.schedulesproject.domain.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto.Add> createSchedule(@Valid @RequestBody ScheduleRequestDto.Add requestDto){

        ScheduleResponseDto.Add response = scheduleService.save(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ScheduleResponseDto.All>> findSchedules(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<All> schedules = scheduleService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto.Single> findSingleSchedule(@PathVariable Long scheduleId){

        Single findSchedule = scheduleService.findById(scheduleId);

        return ResponseEntity.status(HttpStatus.OK).body(findSchedule);
    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto.Update> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequestDto.Update requestDto
    ){
        Update updateSchedule = scheduleService.updateSchedule(scheduleId, requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updateSchedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId){
        scheduleService.deleteSchedule(scheduleId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("게시물 삭제가 완료되었습니다.");
    }


}
