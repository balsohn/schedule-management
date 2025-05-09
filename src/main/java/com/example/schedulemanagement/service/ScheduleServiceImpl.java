package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getTodo(),
                requestDto.getWriter(),
                requestDto.getPassword()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다. ID: " + id));

        return new ScheduleResponseDto(schedule);
    }
}
