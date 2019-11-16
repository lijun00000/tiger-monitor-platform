package com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_64;

import com.tiger.monitor.platform.tigermonitorplatform.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TableMapper {
    //Rapid7Data
    List<Rapid7Data> selectRapid7Data(PageResult pageResult);
    Integer selectRapid7Total(PageResult pageResult);
    //RecordData
    List<RecordData> selectRecordData(PageResult pageResult);
    Integer selectRecordTotal(PageResult pageResult);
    //UploadData
    List<UploadData> selectUploadData(PageResult pageResult);
    Integer selectUploadTotal(PageResult pageResult);
    //ExecutorHistory
    List<ExecutorHistory> selectExecutorHistoryData(PageResult pageResult);
    Integer selectExecutorHistoryTotal(PageResult pageResult);
    List<String> getFileType();
}
