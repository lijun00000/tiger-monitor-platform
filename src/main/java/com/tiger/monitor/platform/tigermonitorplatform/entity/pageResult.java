package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class pageResult {

    Integer pageIndex = 0;//下一页起始下标
    Integer pageSize = 10;//每页显示条数
    Integer total;
    String startTime;
    String endTime;
    String fileType;
    String status;
    String sortName;
    String sortValue;
    List<Rapid7Data> rapid7Data;
    List<RecordData> recordData;
    List<UploadData> uploadData;
    List<ExecutorHistory> executorHistories;

}
