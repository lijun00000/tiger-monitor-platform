package com.tiger.monitor.platform.tigermonitorplatform.dao;

import org.influxdb.InfluxDB;
import org.influxdb.dto.QueryResult;

import java.util.List;

public interface InfluxDBBaseDao {

    List<QueryResult.Result> selectCpuUsageProgress(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    List<QueryResult.Result> selectDiskUsageProgress(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    List<QueryResult.Result> selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    List<QueryResult.Result> selectNetSentProgress(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    List<QueryResult.Result> selectNetRecvProgress(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    List<QueryResult.Result> selectMemoryUsageLine(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);

    List<QueryResult.Result> selectNetSentLine(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);

    List<QueryResult.Result> selectNetRecvLine(String serverNodeName, String startTime, String endTime,InfluxDB influxDB);
    //SELECT derivative("bytes_sent", 1s) FROM "net" WHERE ("host" =~ /^node2\.hxht$/ AND "interface" = 'eno1') AND time >= now() - 5m;

    List<QueryResult.Result> selectDomainConsumerByType(String serverNodeName, String measurement,String startTime, String endTime, String type, InfluxDB influxDB);

    //List<QueryResult.Result> selectDomainProducer(String serverNodeName, String measurement,String startTime, String endTime,String type, InfluxDB influxDB);


}
