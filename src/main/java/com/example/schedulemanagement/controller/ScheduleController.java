package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        ScheduleResponseDto responseDto = scheduleService.getScheduleById(id);

        return ResponseEntity.ok(responseDto);
    }
}
