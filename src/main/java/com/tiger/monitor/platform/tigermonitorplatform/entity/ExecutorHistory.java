package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutorHistory {
    String uuid;
    String fileName;
    String fileType;
    String subType;
    String execTime;
    String activePath;
    String updatePath;
    String historyPath;
    String isDel;
}
