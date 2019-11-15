package com.tiger.monitor.platform.tigermonitorplatform.service.Impl;

import com.alibaba.fastjson.JSON;
import com.tiger.monitor.platform.tigermonitorplatform.dao.BaseDao;
import com.tiger.monitor.platform.tigermonitorplatform.entity.NetSentAndRecvProgress;
import com.tiger.monitor.platform.tigermonitorplatform.entity.UsageDateAndData;
import com.tiger.monitor.platform.tigermonitorplatform.service.SystemPlatformService;
import com.tiger.monitor.platform.tigermonitorplatform.util.Utils;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SystemPlatformServiceImpl implements SystemPlatformService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public Integer selectCpuUsageProgress(String serverNodeName, String startTime, String endTime) {
        List<QueryResult.Result> results = baseDao.selectCpuUsageProgress(serverNodeName, startTime, null);
        AtomicInteger times= new AtomicInteger();
        double usageSum = 0d;
        int useAge =100;
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    double usage =(double) value.get(1);
                    times.getAndIncrement();
                    usageSum = usageSum+usage;
                }
            }
        }
        try {
             useAge =((int)usageSum/times.get());
        }catch (Exception e){
             e.printStackTrace();
        }
        return useAge;
    }

    @Override
    public Integer selectDiskUsageProgress(String serverNodeName, String startTime, String endTime) {
        List<QueryResult.Result> results = baseDao.selectDiskUsageProgress(serverNodeName, startTime, null);
        AtomicInteger times= new AtomicInteger();
        double usageSum = 0d;
        int useAge =100;
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    double usage =(double) value.get(1);
                    times.getAndIncrement();
                    usageSum = usageSum+usage;
                }
            }
        }
        try {
            useAge =((int)usageSum/times.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return useAge;
    }


    @Override
    public Integer selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime) {
        List<QueryResult.Result> results = baseDao.selectMemoryUsageProgress(serverNodeName, startTime, null);
        AtomicInteger times= new AtomicInteger();
        double usageSum = 0d;
        int useAge =100;
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    double usage =(double) value.get(1);
                    times.getAndIncrement();
                    usageSum = usageSum+usage;
                }
            }
        }
        try {
            useAge =((int)usageSum/times.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return useAge;
    }


    @Override
    public Double selectNetRecvProgress(String serverNodeName, String startTime, String endTime) {
        List<QueryResult.Result> results = baseDao.selectNetRecvProgress(serverNodeName, startTime, endTime);
        AtomicInteger times= new AtomicInteger();
        Double usageSum = 0d;
        Double useAge =100d;
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    double usage =(Double) value.get(1);
                    times.getAndIncrement();
                    usageSum = usageSum+usage;
                }
            }
        }
        try {
            useAge =((usageSum*0.125)/times.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return useAge;
    }

    @Override
    public Double selectNetSentProgress(String serverNodeName, String startTime, String endTime) {
        List<QueryResult.Result> results = baseDao.selectNetSentProgress(serverNodeName, startTime, endTime);
        AtomicInteger times= new AtomicInteger();
        Double usageSum = 0d;
        Double useAge =100d;
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    Double usage =(Double) value.get(1);
                    times.getAndIncrement();
                    usageSum = usageSum+usage;
                }
            }
        }
        try {
            useAge =((usageSum*0.125)/times.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return useAge;
    }


    @Override
    public NetSentAndRecvProgress selectNetSentAndRecvProgress(String serverNodeName, String startTime, String endTime) {
        return new NetSentAndRecvProgress(
               Math.round(selectNetSentProgress(serverNodeName, startTime, endTime)/1024/1024/1024),
                Math.round(selectNetRecvProgress(serverNodeName, startTime, endTime)/1024/1024/1024));
    }


    @Override
    public UsageDateAndData selectCpuUsageLine(String serverNodeName, String startTime, String endTime) {
        UsageDateAndData usageDateAndData = new UsageDateAndData(new ArrayList<String>(),new ArrayList<Double>());
        List<QueryResult.Result> results = baseDao.selectCpuUsageProgress(serverNodeName, startTime, null);
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal( (Double) value.get(1));
                    double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    usageDateAndData.getData().add(doubleValue);
                    usageDateAndData.getDateTime().add(Utils.formatZipName((String)value.get(0)));
                }
            }
        }
        return usageDateAndData;
    }

    @Override
    public UsageDateAndData selectMemoryUsageLine(String serverNodeName, String startTime, String endTime) {
        UsageDateAndData usageDateAndData = new UsageDateAndData(new ArrayList<>(),new ArrayList<>());
        List<QueryResult.Result> results = baseDao.selectDiskUsageProgress(serverNodeName, startTime, null);
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal( (Double) value.get(1));
                    double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    usageDateAndData.getData().add(doubleValue);
                    usageDateAndData.getDateTime().add(Utils.formatZipName((String)value.get(0)));
                }
            }
        }
        return usageDateAndData;
    }

    @Override
    public HashMap<String, Object> selectNetSentAndRecvLine(String serverNodeName, String startTime, String endTime) {
        HashMap<String, Object> resultMap = new HashMap<>();
        ArrayList<String> dataTime = new ArrayList<>();
        ArrayList<String> dataSent = new ArrayList<>();
        ArrayList<String> dataRecv= new ArrayList<>();
        List<QueryResult.Result> resultsRecv = baseDao.selectNetRecvLine(serverNodeName, startTime, null);
        List<QueryResult.Result> resultsSent = baseDao.selectNetSentLine(serverNodeName, startTime, null);
        for (QueryResult.Result result : resultsRecv) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal( (Double) value.get(1));
                    double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    dataTime.add(Utils.formatZipName((String)value.get(0)));
                    long round = Math.round((Double) value.get(1));
                    dataRecv.add((round/1024)+"");
                }
            }
        }

        for (QueryResult.Result result : resultsSent) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal((Double)value.get(1));
                    Double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    long round = Math.round((Double) value.get(1));
                    dataSent.add((round/1024)+"");
                }
            }
        }
        resultMap.put("dataTime",dataTime);
        resultMap.put("dataSent",dataSent);
        resultMap.put("dataRecv",dataRecv);
        return resultMap;
    }
}
