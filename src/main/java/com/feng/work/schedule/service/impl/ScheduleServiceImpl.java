package com.feng.work.schedule.service.impl;

import com.feng.work.entity.ScheduleEntity;
import com.feng.work.schedule.dao.ScheduleMapper;
import com.feng.work.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public List<ScheduleEntity> findByCondition(Map<String, String> map) {
        System.out.println("123");
        try {
            Iterator<String> iterator = map.keySet().iterator();
            while(iterator.hasNext()) {
                String next = iterator.next();
                if(StringUtils.isEmpty(map.get(next))){
                    iterator.remove();
                }
            }
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleMapper.findByCondition(map);
    }
}
