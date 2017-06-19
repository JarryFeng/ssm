package com.feng.work.schedule;

import com.feng.work.schedule.service.MyScheduleService;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import java.util.Map;

/**
 * Created by jarry on 2017/6/9.
 */
public class MyScheduleManager {

    private Scheduler scheduler;

    private Map<String, MyScheduleService> serviceMap;

    public void doSomething(String jobKey, String args1) throws SchedulerException {
        //scheduler.getTriggersOfJob(new JobKey(jobKey, Scheduler.DEFAULT_GROUP)).get(0);
        MyScheduleService myScheduleService = serviceMap.get(jobKey);
        System.out.println("我有进来吗");
        myScheduleService.doSomething(args1);
    }

    public Scheduler getScheduler() {

        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Map<String, MyScheduleService> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, MyScheduleService> serviceMap) {
        this.serviceMap = serviceMap;
    }
}
