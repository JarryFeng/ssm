package com.feng.work.schedule.service.impl;

import com.feng.work.schedule.service.MyScheduleService;
import org.springframework.stereotype.Service;

/**
 * 真正被定时任务处理逻辑的类
 * Created by jarry on 2017/6/9.
 */
@Service
public class MyScheduleServiceImpl implements MyScheduleService {

    public void doSomething(String arg1) {
        System.out.println("我被执行了" + arg1);
    }
}
