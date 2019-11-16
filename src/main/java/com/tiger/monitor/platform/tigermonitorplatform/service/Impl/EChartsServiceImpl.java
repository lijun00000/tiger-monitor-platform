package com.tiger.monitor.platform.tigermonitorplatform.service.Impl;

import com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_61.EChartsMapper;
import com.tiger.monitor.platform.tigermonitorplatform.entity.ECharts;
import com.tiger.monitor.platform.tigermonitorplatform.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EChartsServiceImpl implements EChartsService {

    @Autowired
    private EChartsMapper eChartsMapper;

    /**
     * 获取近一个月ECharts数据
     * @return
     */
    @Override
    public ECharts getEChartsDataMonth(ECharts eCharts) {
        List<ECharts> list = eChartsMapper.selectEChartsDataMonth(eCharts);
        return setEChartsList(list);
    }


    /**
     * 对查询到的eCharts统计图所需数据进行处理
     * @param eCharts
     * @return
     */
    private ECharts setEChartsList(List<ECharts> eCharts) {
        if (eCharts.size() == 0) {
            return null;
        }
        ECharts eChartsData = new ECharts();
        Integer seTotal = 0;
        Integer duTotal = 0;
        for (ECharts e: eCharts) {
            seTotal += e.getSeCount();
            duTotal += e.getDuCount();
            eChartsData.getDateForView().add(e.getCreationDate());
            eChartsData.getDateList().add(e.getDate());
            eChartsData.getDuCountList().add(e.getDuCount());
            eChartsData.getSeCountList().add(e.getSeCount());
            eChartsData.getSumCountList().add(e.getSeCount() + e.getDuCount());
        }
        eChartsData.setSeTotal(seTotal);
        eChartsData.setDuTotal(duTotal);
        eChartsData.setTotal(seTotal + duTotal);
        return eChartsData;
    }


}
