package com.tiger.monitor.platform.tigermonitorplatform.service.Impl;

import com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_61.DomainListMapper;
import com.tiger.monitor.platform.tigermonitorplatform.entity.GambleAndSalacityCount;
import com.tiger.monitor.platform.tigermonitorplatform.service.IllegalDomainStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IllegalDomainStatisticsServiceImpl implements IllegalDomainStatisticsService {

    @Autowired
    private DomainListMapper domainListMapper;

    @Override
    public GambleAndSalacityCount countDomainByPageType() {
        ArrayList<String> salacity = new ArrayList<>();
        ArrayList<String> gamble = new ArrayList<>();
        salacity.add("色情");
        gamble.add("赌博");
        Integer salacityCount = domainListMapper.countDomainByPageType(salacity);
        Integer gambleCount = domainListMapper.countDomainByPageType(gamble);
        GambleAndSalacityCount gambleAndSalacityCount = new GambleAndSalacityCount(gambleCount, salacityCount);
        return  gambleAndSalacityCount;
    }
}
