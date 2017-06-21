package com.feng.work.schedule.service.impl;

import com.feng.work.entity.ScheduleEntity;
import com.feng.work.schedule.dao.ScheduleMapper;
import com.feng.work.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jarry on 2017/6/20.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    public List<ScheduleEntity> getAllSchedule() {
        return scheduleMapper.getAllSchedule();
    }
}
