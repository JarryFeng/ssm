package com.feng.work.controller;

import com.feng.work.entity.ScheduleEntity;
import com.feng.work.schedule.service.ScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by jarry on 2017/6/26.
 * 数据库表schedule管理
 */
@Controller
public class ScheduleController {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedule/index")
    public ModelAndView show(@RequestParam Map<String, String> map) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/schedule/index");
        return modelAndView;
    }

    @RequestMapping(value = "/schedule/query", method = RequestMethod.POST)
    @ResponseBody
    public List<ScheduleEntity> query(@RequestBody Map<String, String> map) {
        logger.error(map.toString());
        List<ScheduleEntity> allSchedule = scheduleService.findByCondition(map);
        return allSchedule;
    }
}
