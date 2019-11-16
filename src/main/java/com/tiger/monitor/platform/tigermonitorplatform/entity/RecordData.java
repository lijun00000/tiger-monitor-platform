package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordData {
    String localName;
    String fileType;
    String fileSize;
    String startTime;
    String endTime;
    Integer elapsedTime;
    String downloadStatus;
}
