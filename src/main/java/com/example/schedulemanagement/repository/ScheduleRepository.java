package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.Schedule;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
}
