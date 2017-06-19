package com.feng.work.schedule;

import com.feng.work.utils.SpringContextHolder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务工厂
 * 将定时任务加载到容器中
 * Created by jarry on 2017/6/9.
 */
/*@Component
@DependsOn("springContextHolder")*/
public class MyScheduleFactoryBean extends SchedulerFactoryBean implements ApplicationContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {
        //必须先调用父类，否则启动不了，也就是要按照xml配置先启动定时任务
        super.afterPropertiesSet();
        doSettings();
    }

    /**
     * 将定时任务加载到计划中
     * @throws SchedulerException
     * @throws ParseException
     */
    public void doSettings() throws SchedulerException, ParseException {

        List<Trigger> triggerList = new ArrayList<Trigger>();

        CronTriggerImpl cronTrigger = (CronTriggerImpl)SpringContextHolder.getBean("myTrigger");
        cronTrigger.setCronExpression("0/10 * * * * ?");
        JobDetail jobDetail = (JobDetail)SpringContextHolder.getBean(cronTrigger.getJobName());
        this.getScheduler().scheduleJob(jobDetail, cronTrigger);
        triggerList.add(cronTrigger);
        setTriggers(triggerList.toArray(new Trigger[triggerList.size()]));

        //System.out.println(SpringContextHolder.getBean(this.getClass().getName()));
    }
}
