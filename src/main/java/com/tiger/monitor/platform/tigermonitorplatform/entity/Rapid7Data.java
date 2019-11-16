package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapid7Data {
    String fileName;
    String fileType;
    String fileSize;
    String downloadTime;
    String downloadStatus;
}
