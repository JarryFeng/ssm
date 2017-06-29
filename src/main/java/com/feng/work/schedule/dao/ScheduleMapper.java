package com.feng.work.schedule.dao;

import com.feng.work.entity.ScheduleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by jarry on 2017/6/20.
 */
public interface ScheduleMapper {
    public List<ScheduleEntity> getAllSchedule();

    List<ScheduleEntity> findByCondition( Map<String, String> map);
}
