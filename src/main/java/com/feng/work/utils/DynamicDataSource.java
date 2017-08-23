package com.feng.work.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切库类
 * Created by jarry on 2017/8/23.
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.determineCurrentLookupKey();
    }
}
