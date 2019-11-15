package com.tiger.monitor.platform.tigermonitorplatform.service;


import com.tiger.monitor.platform.tigermonitorplatform.entity.NetSentAndRecvProgress;
import com.tiger.monitor.platform.tigermonitorplatform.entity.UsageDateAndData;
import org.influxdb.dto.QueryResult;

import java.util.HashMap;
import java.util.List;

public interface SystemPlatformService {


    Integer selectCpuUsageProgress(String serverNodeName, String startTime, String endTime);

    Integer selectDiskUsageProgress(String serverNodeName, String startTime, String endTime);

    Integer selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime);

    Double selectNetRecvProgress(String serverNodeName, String startTime, String endTime);

    Double selectNetSentProgress(String serverNodeName, String startTime, String endTime);

    NetSentAndRecvProgress selectNetSentAndRecvProgress(String serverNodeName, String startTime, String endTime);

    UsageDateAndData selectCpuUsageLine(String serverNodeName, String startTime, String endTime);

    UsageDateAndData selectMemoryUsageLine(String serverNodeName, String startTime, String endTime);


    HashMap<String,Object> selectNetSentAndRecvLine(String serverNodeName, String startTime, String endTime);



}
