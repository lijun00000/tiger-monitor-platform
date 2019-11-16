package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadData {
    String uuid;
    String fileName;
    String path;
    String fileLength;
    String fileType;
    String subType;
    String fileTime;
    String uploadTime;
    String startExecTime;
    String elapsedTime;
    String execState;
}
