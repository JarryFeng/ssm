package com.feng.work.schedule;

import com.feng.work.entity.ScheduleEntity;
import com.feng.work.schedule.service.MyScheduleService;
import com.feng.work.schedule.service.ScheduleService;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.scheduling.Trigger;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 管理业务和计划
 * Created by jarry on 2017/6/9.
 */
public class MyScheduleManager {

    private Scheduler scheduler;

    private Map<String, MyScheduleService> serviceMap;

    private ScheduleService scheduleService;

    public void doSomething(String jobKey, String args1) {
        //处理真正的业务
        doRealThings(jobKey, args1);
        //看看执行计划是否有变化
        try {
            doScheduleJob(jobKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否重新加载任务
     * @param jobKey
     * @throws SchedulerException
     * @throws ParseException
     */
    private void doScheduleJob(String jobKey) throws SchedulerException, ParseException {
        String name = scheduler.getTriggersOfJob(new JobKey(jobKey, Scheduler.DEFAULT_GROUP)).get(0).getKey().getName();
        //CronTriggerImpl trigger = (CronTriggerImpl)scheduler.getTriggersOfJob(new JobKey(jobKey, Scheduler.DEFAULT_GROUP)).get(0);
        CronTriggerImpl trigger = (CronTriggerImpl)scheduler.getTrigger(new TriggerKey(name, Scheduler.DEFAULT_GROUP));

        List<ScheduleEntity> scheduleEntityList = scheduleService.getAllSchedule();
        for(ScheduleEntity scheduleEntity : scheduleEntityList){
            if(!StringUtils.isEmpty(scheduleEntity.getTriggerName()) && scheduleEntity.getTriggerName().equals(name)) {
                if(!trigger.getCronExpression().equals(scheduleEntity.getCronExpresion())) {
                    System.out.println("我要重置了");
                    trigger.setCronExpression(scheduleEntity.getCronExpresion());
                    scheduler.rescheduleJob(new TriggerKey(name, Scheduler.DEFAULT_GROUP), trigger);
                }
            }
        }
    }

    /**
     * 处理业务
     * @param jobKey
     * @param args1
     */
    private void doRealThings(String jobKey, String args1) {
        //scheduler.getTriggersOfJob(new JobKey(jobKey, Scheduler.DEFAULT_GROUP)).get(0);
        MyScheduleService myScheduleService = serviceMap.get(jobKey);
        System.out.println("我要处理真实业务了");
        myScheduleService.doSomething(args1);
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

    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
}
