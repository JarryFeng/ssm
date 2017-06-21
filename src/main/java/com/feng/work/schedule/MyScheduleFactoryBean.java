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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * 定时任务工厂
 * 将定时任务加载到容器中
 * Created by jarry on 2017/6/9.
 */
/*@Component
@DependsOn("springContextHolder")*/
public class MyScheduleFactoryBean extends SchedulerFactoryBean implements ApplicationContextAware {

    private static Properties properties;

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
    public void doSettings() throws SchedulerException, ParseException, IOException {

        Properties properties = loadProperties();

        List<Trigger> triggerList = new ArrayList<Trigger>();
        if(properties != null) {
            Enumeration<?> enumeration = properties.propertyNames();
            while(enumeration.hasMoreElements()) {
                String key = (String)enumeration.nextElement();
                if("on".equals(properties.getProperty(key))) {
                    CronTriggerImpl cronTrigger = (CronTriggerImpl)SpringContextHolder.getBean(key);
                    if(cronTrigger != null) {
                        JobDetail jobDetail = (JobDetail)SpringContextHolder.getBean(cronTrigger.getJobName());
                        if(jobDetail != null) {
                            this.getScheduler().scheduleJob(jobDetail, cronTrigger);
                            triggerList.add(cronTrigger);
                        }
                    }
                }
            }
        }

        setTriggers(triggerList.toArray(new Trigger[triggerList.size()]));

        //System.out.println(SpringContextHolder.getBean(this.getClass().getName()));
    }

    /**
     * 加载配置文件
     * @return
     * @throws IOException
     */
    private Properties loadProperties() throws IOException {
        if(properties == null) {
            properties = new Properties();
            String propertiesPath = "/properties/schedule.properties";
            properties.load(this.getClass().getResourceAsStream(propertiesPath));
        }
        return properties;
    }
}
