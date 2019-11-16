package com.tiger.monitor.platform.tigermonitorplatform.controller;

import com.alibaba.fastjson.JSON;
import com.tiger.monitor.platform.tigermonitorplatform.entity.GambleAndSalacityCount;
import com.tiger.monitor.platform.tigermonitorplatform.service.IllegalDomainStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IllegalDomainController {

    @Autowired
    private IllegalDomainStatisticsService illegalDomainStatistics;

    @RequestMapping(value = "/IllegalDomainCount")
    public Object countIllegalDomain(){
        GambleAndSalacityCount gambleAndSalacityCount = illegalDomainStatistics.countDomainByPageType();
        return gambleAndSalacityCount;
    }

}
