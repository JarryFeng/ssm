package com.feng.work.schedule.service;

import com.feng.work.entity.ScheduleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by jarry on 2017/6/20.
 */
public interface ScheduleService {
    public List<ScheduleEntity> getAllSchedule();

    public List<ScheduleEntity> findByCondition(Map<String, String> map);
}
