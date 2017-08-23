package com.feng.work.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by jarry on 2017/8/23.
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal();

    private static final Logger logger = LoggerFactory.getLogger(DataSourceHolder.class);

    public static void setDataSource(String key){
        threadLocal.set(key);
    }

    public static String determineCurrentLookupKey(){
        logger.info("当前数据库：" + threadLocal.get());
        return threadLocal.get();
    }

    public static String getDataSource(){
        String dbkey = threadLocal.get();
        if(StringUtils.isEmpty(dbkey)){
            dbkey = getDefaultDataSource();
        }

        return dbkey;
    }

    public static String getDefaultDataSource() {
        String defaultDataSource = (String) SpringContextHolder.getBean("defaultDataSource");
        return defaultDataSource.trim();
    }
}
