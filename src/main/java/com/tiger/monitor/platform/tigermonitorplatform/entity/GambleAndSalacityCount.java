package com.tiger.monitor.platform.tigermonitorplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GambleAndSalacityCount {
    private  Integer  illegalCount;
    private  Integer  salacityCount;
    private  Integer  gambleCount;
    private  Integer  gambleRatio;
    private  Integer  salacityRatio;

    public GambleAndSalacityCount(Integer gambleCount,Integer salacityCount){
        this.illegalCount=(gambleCount+salacityCount);
        this.gambleCount = gambleCount;
        this.salacityCount= salacityCount;
        this.salacityRatio= Math.round(((float)salacityCount/(float)(salacityCount+gambleCount))*100);
        this.gambleRatio= Math.round(((float)gambleCount/(float)(salacityCount+gambleCount))*100);
    }
}
