package com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_61;

import com.tiger.monitor.platform.tigermonitorplatform.entity.ECharts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EChartsMapper {

    List<ECharts> selectEChartsDataMonth(ECharts eCharts);

}
