package com.tiger.monitor.platform.tigermonitorplatform.service.Impl;

import com.alibaba.fastjson.JSON;
import com.tiger.monitor.platform.tigermonitorplatform.dao.InfluxDBBaseDao;
import com.tiger.monitor.platform.tigermonitorplatform.entity.DomainProcessorMeter;
import com.tiger.monitor.platform.tigermonitorplatform.entity.NetSentAndRecvProgress;
import com.tiger.monitor.platform.tigermonitorplatform.entity.UsageDateAndData;
import com.tiger.monitor.platform.tigermonitorplatform.service.SystemPlatformService;
import com.tiger.monitor.platform.tigermonitorplatform.util.InfluxDbUtils;
import com.tiger.monitor.platform.tigermonitorplatform.util.Utils;
import org.influxdb.InfluxDB;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SystemPlatformServiceImpl implements SystemPlatformService {

    @Autowired
    private InfluxDbUtils influxDbUtils;

    @Autowired
    private InfluxDBBaseDao baseDao;

    @Override
    public Integer selectCpuUsageProgress(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> results = baseDao.selectCpuUsageProgress(serverNodeName, startTime, null,influxDB);
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
        influxDB.close();
        return useAge;
    }

    @Override
    public Integer selectDiskUsageProgress(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> results = baseDao.selectDiskUsageProgress(serverNodeName, startTime, null,influxDB);
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
        influxDB.close();
        return useAge;
    }


    @Override
    public Integer selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> results = baseDao.selectMemoryUsageProgress(serverNodeName, startTime, null,influxDB);
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
        influxDB.close();
        return useAge;
    }


    @Override
    public Double selectNetRecvProgress(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> results = baseDao.selectNetRecvProgress(serverNodeName, startTime, endTime,influxDB);
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
        influxDB.close();
        return useAge;
    }

    @Override
    public Double selectNetSentProgress(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> results = baseDao.selectNetSentProgress(serverNodeName, startTime, endTime,influxDB);
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
        influxDB.close();
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
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        UsageDateAndData usageDateAndData = new UsageDateAndData(new ArrayList<String>(),new ArrayList<Double>());
        List<QueryResult.Result> results = baseDao.selectCpuUsageProgress(serverNodeName, startTime, null,influxDB);
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal( (Double) value.get(1));
                    double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    usageDateAndData.getData().add(doubleValue);
                    usageDateAndData.getDateTime().add(Utils.formatTimeHHmmss((String)value.get(0)));
                }
            }
        }
        influxDB.close();
        return usageDateAndData;
    }

    @Override
    public UsageDateAndData selectMemoryUsageLine(String serverNodeName, String startTime, String endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        UsageDateAndData usageDateAndData = new UsageDateAndData(new ArrayList<>(),new ArrayList<>());
        List<QueryResult.Result> results = baseDao.selectDiskUsageProgress(serverNodeName, startTime, null,influxDB);
        for (QueryResult.Result result : results) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    BigDecimal b = new BigDecimal( (Double) value.get(1));
                    double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    usageDateAndData.getData().add(doubleValue);
                    usageDateAndData.getDateTime().add(Utils.formatTimeHHmmss((String)value.get(0)));
                }
            }
        }
        influxDB.close();
        return usageDateAndData;
    }

    @Override
    public HashMap<String, Object> selectNetSentAndRecvLine(String serverNodeName, String startTime, String endTime) {
        HashMap<String, Object> resultMap = new HashMap<>();
        ArrayList<String> dataTime = new ArrayList<>();
        ArrayList<String> dataSent = new ArrayList<>();
        ArrayList<String> dataRecv= new ArrayList<>();
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        List<QueryResult.Result> resultsRecv = baseDao.selectNetRecvLine(serverNodeName, startTime, null,influxDB);
        List<QueryResult.Result> resultsSent = baseDao.selectNetSentLine(serverNodeName, startTime, null,influxDB);
        for (QueryResult.Result result : resultsRecv) {
            List<QueryResult.Series> series = result.getSeries();
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    dataTime.add(Utils.formatTimeHHmmss((String)value.get(0)));
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
        influxDB.close();
        return resultMap;
    }


    @Override
    public DomainProcessorMeter selectDomainConsumerByType( long startTime, long endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        influxDB.setDatabase("domain_meter");
        String  measurement="domain_consumer_meter";
        String  gamble="gamble";
        String  porn="porn";
        // gamble porn  domain_consumer_meter
        DomainProcessorMeter domainProcessorMeter = new DomainProcessorMeter();
        ArrayList<String> dataTimes =new ArrayList<>();
        ArrayList<Integer> gambleData=new ArrayList<>();
        ArrayList<Integer> salacityData=new ArrayList<>();
        ArrayList<Integer> salacityAndGambleCountData=new ArrayList<>();
        List<QueryResult.Result> gambleResult = baseDao.selectDomainConsumerByType(null,measurement, startTime+"ms", endTime+"ms", gamble,influxDB);
        List<QueryResult.Result> pornResult = baseDao.selectDomainConsumerByType(null, measurement,startTime+"ms", endTime+"ms", porn,influxDB);
        //赌博
        for (QueryResult.Result result : gambleResult) {
            List<QueryResult.Series> series = result.getSeries();
            if (series==null){
                resetResult(domainProcessorMeter,dataTimes,gambleData,salacityData,salacityAndGambleCountData,startTime,endTime);break;}
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    String dataTime = Utils.formatTimeHHmmss((String) value.get(0));
                    dataTimes.add(dataTime);
                    Integer number = (Integer)value.get(1);
                    gambleData.add(number);
                }
            }
        }
        //色情
        for (QueryResult.Result result : pornResult) {
            List<QueryResult.Series> series = result.getSeries();
            if (series==null){  break;}
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (int i = 0; i <values.size() ; i++) {
                    List<Object> objects = values.get(i);
                    Integer number = (Integer)objects.get(1);
                    salacityData.add(number);
                    Integer integer = gambleData.get(i);
                    salacityAndGambleCountData.add(number+integer);
                }
            }
        }
        domainProcessorMeter.setDataTime(dataTimes);
        domainProcessorMeter.setGambleData(gambleData);
        domainProcessorMeter.setSalacityData(salacityData);
        domainProcessorMeter.setSalacityAndGambleCountData(salacityAndGambleCountData);
        influxDB.close();
        return domainProcessorMeter;
    }


    @Override
    public DomainProcessorMeter selectDomainProducerByType(long startTime, long endTime) {
        InfluxDB influxDB = influxDbUtils.influxDbBuild();
        influxDB.setDatabase("domain_meter");
        String  measurement="domain_produce_meter";
        String  gamble="gamble";
        String  porn="porn";
        // gamble porn  domain_consumer_meter
        DomainProcessorMeter domainProcessorMeter = new DomainProcessorMeter();
        ArrayList<String> dataTimes =new ArrayList<>();
        ArrayList<Integer> gambleData=new ArrayList<>();
        ArrayList<Integer> salacityData=new ArrayList<>();
        ArrayList<Integer> salacityAndGambleCountData=new ArrayList<>();
        List<QueryResult.Result> gambleResult = baseDao.selectDomainConsumerByType(null,measurement,
                startTime+"ms", endTime+"ms", gamble,influxDB);
        List<QueryResult.Result> pornResult = baseDao.selectDomainConsumerByType(null, measurement,
                startTime+"ms", endTime+"ms", porn,influxDB);
        //赌博
        for (QueryResult.Result result : gambleResult) {
            List<QueryResult.Series> series = result.getSeries();
            if (series==null){
                resetResult(domainProcessorMeter,dataTimes,gambleData,salacityData,salacityAndGambleCountData,startTime,endTime);; break;}
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (List<Object> value : values) {
                    String dataTime = Utils.formatTimeHHmmss((String) value.get(0));
                    dataTimes.add(dataTime);
                    Integer number = (Integer)value.get(1);
                    gambleData.add(number);
                }
            }
        }
        //色情
        for (QueryResult.Result result : pornResult) {
            List<QueryResult.Series> series = result.getSeries();
            if (series==null){  break;}
            for (QueryResult.Series series1 : series) {
                List<List<Object>> values = series1.getValues();
                for (int i = 0; i <values.size() ; i++) {
                    List<Object> objects = values.get(i);
                    Integer number = (Integer)objects.get(1);
                    salacityData.add(number);
                    Integer integer = gambleData.get(i);
                    salacityAndGambleCountData.add(number+integer);
                }
            }
        }
        domainProcessorMeter.setDataTime(dataTimes);
        domainProcessorMeter.setGambleData(gambleData);
        domainProcessorMeter.setSalacityData(salacityData);
        domainProcessorMeter.setSalacityAndGambleCountData(salacityAndGambleCountData);
        influxDB.close();
        return domainProcessorMeter;
    }


    private void resetResult(DomainProcessorMeter domainMeter,ArrayList<String> dataTimes,
                             ArrayList<Integer> gambleData,ArrayList<Integer> salacityData,
                             ArrayList<Integer> salacityAndGambleCountData,long statTime,long endTime){
        long  interval=(endTime-statTime)/1000;
        for (int i = 0; i <interval ; i++) {
         long  temp = statTime+(i*1000);
            dataTimes.add(Utils.formatTimeHHmmss(temp));
            gambleData.add(0);
            salacityData.add(0);
            salacityAndGambleCountData.add(0);
        }
        domainMeter.setDataTime(dataTimes);
        domainMeter.setGambleData(gambleData);
        domainMeter.setSalacityData(salacityData);
        domainMeter.setSalacityAndGambleCountData(salacityAndGambleCountData);
    }
}