package com.tiger.monitor.platform.tigermonitorplatform.controller;

import com.tiger.monitor.platform.tigermonitorplatform.entity.ECharts;
import com.tiger.monitor.platform.tigermonitorplatform.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EChartsController {

    @Autowired
    private EChartsService eChartsService;

    @RequestMapping("/getEChartsDataMonth")
    public ECharts getEChartsDataMonth() {
        try {
            System.out.println("in controller");
            ECharts e = new ECharts();
            return eChartsService.getEChartsDataMonth(e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
