package com.tiger.monitor.platform.tigermonitorplatform.config;

import com.tiger.monitor.platform.tigermonitorplatform.util.InfluxDbUtils;
import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${tiger.monitor.platform.influxDB.url:http://192.168.0.65:8086}")
    private String influxDBUrl;
    @Value("${tiger.monitor.platform.influxDB.userName:''}")
    private String userName;
    @Value("${tiger.monitor.platform.influxDB.password:''}")
    private String password;
    @Value("${tiger.monitor.platform.influxDB.database:telegraf}")
    private String database;
    private String retentionPolicy;

/*    private InfluxDB influxDB;*/
    // 数据保存策略
    public static String policyNamePix = "logRetentionPolicy_";

    @Bean
    public InfluxDbUtils influxDbUtils() {
        return new InfluxDbUtils(userName, password, influxDBUrl, database, "");
    }





}
