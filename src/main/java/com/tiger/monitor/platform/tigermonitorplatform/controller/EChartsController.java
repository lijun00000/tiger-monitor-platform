package com.tiger.monitor.platform.tigermonitorplatform.controller;

import com.tiger.monitor.platform.tigermonitorplatform.entity.ECharts;
import com.tiger.monitor.platform.tigermonitorplatform.entity.PageResult;
import com.tiger.monitor.platform.tigermonitorplatform.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EChartsController {

    @Autowired
    private EChartsService service;

    @RequestMapping("/getRapid7Data")
    public PageResult getRapid7Data(@RequestBody PageResult pageResult) {
        try {
            return service.getRapid7Data(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getRecordData")
    public PageResult getRecordData(@RequestBody PageResult pageResult) {
        try {
            return service.getRecordData(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getUploadData")
    public PageResult getUploadData(@RequestBody PageResult pageResult) {
        try {
            return service.getUploadData(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getExecutorHistoryData")
    public PageResult getExecutorHistoryData(@RequestBody PageResult pageResult) {
        try {
            return service.getExecutorHistoryData(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getEChartsDataMonth")
    public ECharts getEChartsDataMonth() {
        try {
            ECharts e = new ECharts();
            return service.getEChartsDataMonth(e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/test")
    public void test() {

    }

}
