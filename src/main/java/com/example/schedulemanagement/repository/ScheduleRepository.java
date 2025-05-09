package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
    Optional<Schedule> findById(Long id);
    List<Schedule> findAllSchedule();
}
