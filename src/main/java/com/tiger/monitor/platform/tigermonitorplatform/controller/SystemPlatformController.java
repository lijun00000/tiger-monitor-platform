package com.tiger.monitor.platform.tigermonitorplatform.controller;

import com.tiger.monitor.platform.tigermonitorplatform.entity.DomainProcessorMeter;
import com.tiger.monitor.platform.tigermonitorplatform.service.SystemPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemPlatformController {

    @Autowired
    private SystemPlatformService systemPlatformService;


    /**
     * cpu使用率 进度条
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/cupProgress/{hostNode}")
    public Object cupProgress(@PathVariable("hostNode") String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectCpuUsageProgress(serverName,currentTimeMillis+"ms",null);
    }

    /**
     * 内存 使用率 进度条
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/memoryProgress/{hostNode}")
    public Object memoryProgress(@PathVariable("hostNode")String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectMemoryUsageProgress(serverName,currentTimeMillis+"ms",null);
    }

    /**
     * 磁盘使用率 进度条
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/diskProgress/{hostNode}")
    public Object diskProgress(@PathVariable("hostNode")String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectDiskUsageProgress(serverName,currentTimeMillis+"ms",null);
    }

    /**
     * 网络吞吐比 进度条
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/netProgress/{hostNode}")
    public Object netProgress(@PathVariable("hostNode")String hostNode){
        long  endTime = System.currentTimeMillis()-1000*60*5;
        long  startTime= endTime-180000;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectNetSentAndRecvProgress(serverName,startTime+"ms",endTime+"ms");
    }


    /**
     * cpu 使用率 仪表盘
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/cpuGauge/{hostNode}")
    public Object cpuGauge(@PathVariable("hostNode")String hostNode){ return null;}

    /**
     * 内存 使用率 仪表盘
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/memoryGauge/{hostNode}")
    public Object memoryGauge(@PathVariable("hostNode")String hostNode){ return null;}

    /**
     * 磁盘 使用率 仪表盘
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/diskGauge/{hostNode}")
    public Object diskGauge(@PathVariable("hostNode")String hostNode){ return null;}



    /**
     *  cup使用率 折线
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/cpuLine/{hostNode}")
    public Object cpuLine(@PathVariable("hostNode")String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectCpuUsageLine(serverName,currentTimeMillis+"ms",null);
    }

    /**
     * 内存 折线
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/memoryLine/{hostNode}")
    public Object memoryLine(@PathVariable("hostNode")String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectMemoryUsageLine(serverName,currentTimeMillis+"ms",null);
    }

    /**
     *  网络吞吐 折线
     * @param hostNode
     * @return
     */
    @RequestMapping(value = "/netLine/{hostNode}")
    public Object netLine(@PathVariable("hostNode")String hostNode){
        long  currentTimeMillis = System.currentTimeMillis()-1000*60*5;
        String serverName = getServerName(hostNode);
        return systemPlatformService.selectNetSentAndRecvLine(serverName,currentTimeMillis+"ms",null);
    }

    /**
     * 发送域名的数量
     * @return
     */
    @RequestMapping(value = "/domainProducer")
    public Object domainProducer(){
        long endTime = System.currentTimeMillis();
        long startTime = endTime-1000*60*5;
        DomainProcessorMeter domainProcessorMeter = systemPlatformService.selectDomainProducerByType( startTime,  endTime);
        return domainProcessorMeter;
    }

    /**
     * 域名处理的速率
     * @return
     */
    @RequestMapping(value = "/domainConsumer")
    public Object domainConsumer(){
        long endTime = System.currentTimeMillis();
        long startTime = endTime-1000*60*5;
        DomainProcessorMeter domainProcessorMeter = systemPlatformService.selectDomainConsumerByType(startTime,endTime );
        return domainProcessorMeter;
    }

    private String getServerName(String name){
        String serveName="";
        switch (name){
            case "node1": serveName = "node1.hxht";break;
            case "node2": serveName = "node2.hxht";break;
            case "node3": serveName = "node3.hxht";break;
            case "node4": serveName = "node4.hxht";break;
            case "node5": serveName = "node5.hxht";break;
            case "node6": serveName = "node6.hxht";break;
        }
        return serveName;
    }
}
