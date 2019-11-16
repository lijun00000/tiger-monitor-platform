package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ECharts {

    private String startDate;//查询参数

    private String endDate;//查询参数

    private String date;

    private String creationDate;

    private Integer seCount;

    private Integer duCount;

    private Integer seTotal;

    private Integer duTotal;

    private Integer total;

    private List<String> dateForView = new ArrayList<>();//前台日期选择框展示需要的日期格式

    private List<String> dateList = new ArrayList<>();//前台eCharts统计同展示需要的日期格式

    private List<Integer> seCountList = new ArrayList<>();//

    private List<Integer> duCountList = new ArrayList<>();

    private List<Integer> sumCountList = new ArrayList<>();
}
