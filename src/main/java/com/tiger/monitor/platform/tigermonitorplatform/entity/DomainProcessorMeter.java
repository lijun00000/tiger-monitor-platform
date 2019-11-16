package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class DomainProcessorMeter {
    private ArrayList<String> dataTime;
    private ArrayList<Integer> gambleData;
    private ArrayList<Integer> salacityData;
    private ArrayList<Integer> salacityAndGambleCountData;
}
