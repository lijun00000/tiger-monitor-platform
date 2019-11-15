package com.tiger.monitor.platform.tigermonitorplatform.dao;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.tiger.monitor.platform.tigermonitorplatform.util.InfluxDbUtils;
import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private InfluxDbUtils influxDbUtils;

    private InfluxDB influxDB;

    @Override
    public List<QueryResult.Result> selectCpuUsageProgress(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append(" SELECT usage_user FROM  cpu  WHERE ( host = '")
                      .append(serverNodeName).append("') AND  time >=")
                      .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        return results;
    }
    @Override
    public List<QueryResult.Result> selectDiskUsageProgress(String serverNodeName, String startTime, String endTime) {
       ////SELECT "used_percent" FROM "disk" WHERE ("host" =~ /^node1\.hxht$/ AND "path" = '/alldata') AND time >= now() - 5m
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT used_percent FROM disk WHERE (host ='")
                .append(serverNodeName).append("') AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }


    @Override
    public List<QueryResult.Result> selectMemoryUsageProgress(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT used_percent FROM mem WHERE (host ='")
                .append(serverNodeName).append("') AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }


    @Override
    public List<QueryResult.Result> selectMemoryUsageLine(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT used FROM mem WHERE (host ='")
                .append(serverNodeName).append("') AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }

    @Override
    public List<QueryResult.Result> selectNetSentProgress(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT bytes_sent  FROM net WHERE (host ='")
                     .append(serverNodeName)
                     .append("') AND  time >=")
                     .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }

    @Override
    public List<QueryResult.Result> selectNetRecvProgress(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT bytes_recv  FROM net WHERE (host ='")
                .append(serverNodeName)
                .append("') AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }

    // SELECT derivative("bytes_sent", 1s) FROM "net" WHERE ("host" =~ /^node2\.hxht$/ AND "interface" = 'eno1') AND time >= now() - 5m;
    @Override
    public List<QueryResult.Result> selectNetSentLine(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT derivative( bytes_sent, 1s) FROM net WHERE (host ='")
                .append(serverNodeName)
                .append("' AND  interface = 'eno1')  AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }

    @Override
    public List<QueryResult.Result> selectNetRecvLine(String serverNodeName, String startTime, String endTime) {
        influxDB = influxDbUtils.getInfluxDB();
        StringBuffer querySqlBuffer = new StringBuffer();
        querySqlBuffer.append("SELECT derivative( bytes_recv, 1s) FROM net WHERE (host ='")
                .append(serverNodeName)
                .append("' AND  interface = 'eno1')  AND  time >=")
                .append(startTime);
        Query query = new Query(querySqlBuffer.toString());
        QueryResult queryResult = influxDB.query(query);
        List<QueryResult.Result> results = queryResult.getResults();
        influxDB.close();
        return results;
    }
}
