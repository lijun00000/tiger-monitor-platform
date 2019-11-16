package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {

    Integer pageIndex = 0;//下一页起始下标
    Integer pageSize = 10;//每页显示条数
    String startTime;//请求参数
    String endTime;//请求参数
    String fileType;//请求参数
    String status;//请求参数
    String sortName;//请求参数
    String sortValue;//请求参数
    Integer total;//数据条目数
    List<Rapid7Data> rapid7Data;//结果集
    List<RecordData> recordData;//结果集
    List<UploadData> uploadData;//结果集
    List<ExecutorHistory> executorHistories;//结果集
    List<String> types;

}
