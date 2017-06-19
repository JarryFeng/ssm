package com.feng.work.schedule;

import com.feng.work.utils.SpringContextHolder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * 定时任务工厂
 * Created by jarry on 2017/6/9.
 */
/*@Component
@DependsOn("springContextHolder")*/
public class MyScheduleFactoryBean extends SchedulerFactoryBean implements ApplicationContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        setting();
    }

    public void setting() throws SchedulerException, ParseException {
        Object o = SpringContextHolder.getBean("myTrigger");
        System.out.println("1123123123:"+ o);
        CronTriggerImpl cronTrigger = (CronTriggerImpl)o;
        cronTrigger.setCronExpression("0/10 * * * * ?");
        JobDetail jobDetail = (JobDetail)SpringContextHolder.getBean(cronTrigger.getJobName());
        this.getScheduler().scheduleJob(jobDetail, cronTrigger);
        setTriggers(cronTrigger);

        //System.out.println(SpringContextHolder.getBean(this.getClass().getName()));
    }
}
