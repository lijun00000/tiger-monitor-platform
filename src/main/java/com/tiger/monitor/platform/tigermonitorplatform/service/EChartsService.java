package com.tiger.monitor.platform.tigermonitorplatform.service;

import com.tiger.monitor.platform.tigermonitorplatform.entity.*;

import java.text.ParseException;
import java.util.List;

public interface EChartsService {

    ECharts getEChartsDataMonth(ECharts eCharts);
    //Rapid7Data
    PageResult getRapid7Data(PageResult pageResult) throws ParseException;
    //RecordData
    PageResult getRecordData(PageResult pageResult) throws ParseException;
    //UploadData
    PageResult getUploadData(PageResult pageResult) throws ParseException;
    //ExecutorHistory
    PageResult getExecutorHistoryData(PageResult pageResult) throws ParseException;

}
