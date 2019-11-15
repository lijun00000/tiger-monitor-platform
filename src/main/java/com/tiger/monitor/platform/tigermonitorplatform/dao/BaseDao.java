package com.tiger.monitor.platform.tigermonitorplatform.dao;

import org.influxdb.dto.QueryResult;

import java.util.List;

public interface BaseDao {

    List<QueryResult.Result> selectCpuUsageProgress(String serverNodeName, String startTime, String endTime);
    List<QueryResult.Result> selectDiskUsageProgress(String serverNodeName, String startTime, String endTime);
    List<QueryResult.Result> selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime);
    List<QueryResult.Result> selectNetSentProgress(String serverNodeName, String startTime, String endTime);
    List<QueryResult.Result> selectNetRecvProgress(String serverNodeName, String startTime, String endTime);
    List<QueryResult.Result> selectMemoryUsageLine(String serverNodeName, String startTime, String endTime);

    List<QueryResult.Result> selectNetSentLine(String serverNodeName, String startTime, String endTime);

    List<QueryResult.Result> selectNetRecvLine(String serverNodeName, String startTime, String endTime);
    //SELECT derivative("bytes_sent", 1s) FROM "net" WHERE ("host" =~ /^node2\.hxht$/ AND "interface" = 'eno1') AND time >= now() - 5m;

}
