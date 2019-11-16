package com.tiger.monitor.platform.tigermonitorplatform.service.Impl;

import com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_61.EChartsMapper;
import com.tiger.monitor.platform.tigermonitorplatform.dao.mapper_64.TableMapper;
import com.tiger.monitor.platform.tigermonitorplatform.entity.*;
import com.tiger.monitor.platform.tigermonitorplatform.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EChartsServiceImpl implements EChartsService {

    @Autowired
    private EChartsMapper eChartsMapper;
    @Autowired
    private TableMapper tableMapper;

    //Rapid7Data
    public PageResult getRapid7Data(PageResult pageResult) throws ParseException {
        setParam(pageResult, "rapid7");
        System.out.println(pageResult);
        List<Rapid7Data> list = tableMapper.selectRapid7Data(pageResult);
        if (list.size() != 0) {
            for (Rapid7Data r: list) {
                if (r.getFileSize() != null && !"".equals(r.getFileSize())) {
                    r.setFileSize(setFileLength(r.getFileSize()));
                }
                if (r.getDownloadTime() != null && !"".equals(r.getDownloadTime())) {
                    r.setDownloadTime(r.getDownloadTime().substring(0, 10));
                }
            }
        }
        Integer total = tableMapper.selectRapid7Total(pageResult);
        pageResult.setRapid7Data(list);
        pageResult.setTotal(total);
        pageResult.setPageIndex(pageResult.getPageIndex()/pageResult.getPageSize() + 1);
        System.out.println(pageResult);
        return pageResult;
    }
    //RecordData
    public PageResult getRecordData(PageResult pageResult) throws ParseException {
        setParam(pageResult, "record");
        System.out.println(pageResult);
        List<RecordData> list = tableMapper.selectRecordData(pageResult);
        Integer total = tableMapper.selectRecordTotal(pageResult);
        if (list.size() != 0) {
            for (RecordData r: list) {
                if (r.getFileSize() != null && !"".equals(r.getFileSize())) {
                    r.setFileSize(setFileLength(r.getFileSize()));
                }
                if (r.getStartTime() != null && !"".equals(r.getStartTime())) {
                    r.setStartTime(r.getStartTime().substring(0, 10));
                }
                if (r.getEndTime() != null && !"".equals(r.getEndTime())) {
                    r.setEndTime(r.getEndTime().substring(0, 10));
                }
            }
        }
        pageResult.setRecordData(list);
        pageResult.setTotal(total);
        System.out.println(pageResult);
        return pageResult;
    }
    //UploadData
    public PageResult getUploadData(PageResult pageResult) throws ParseException {
        setParam(pageResult, "upload");
        System.out.println(pageResult);
        List<UploadData> list = tableMapper.selectUploadData(pageResult);
        Integer total = tableMapper.selectUploadTotal(pageResult);
        if (list.size() != 0) {
            for (UploadData r: list) {
                if (r.getFileLength() != null && !"".equals(r.getFileLength())) {
                    r.setFileLength(setFileLength(r.getFileLength()));
                }
                if (r.getUploadTime() != null && !"".equals(r.getUploadTime())) {
                    r.setUploadTime(setTimeFormat(r.getUploadTime()));
                }
                if (r.getFileTime() != null && !"".equals(r.getFileTime())) {
                    r.setFileTime(setTimeFormat(r.getFileTime()));
                }
                if (r.getStartExecTime() != null && !"0".equals(r.getStartExecTime())) {
                    r.setStartExecTime(setTimeFormat(r.getStartExecTime()));
                }
            }
        }
        pageResult.setUploadData(list);
        pageResult.setTotal(total);
        System.out.println(pageResult);
        return pageResult;
    }
    //ExecutorHistory
    public PageResult getExecutorHistoryData(PageResult pageResult) throws ParseException {
        setParam(pageResult, "exec");
        System.out.println(pageResult);
        List<ExecutorHistory> list = tableMapper.selectExecutorHistoryData(pageResult);
        if (list.size() != 0) {
            for (ExecutorHistory r: list) {
                if (r.getExecTime() != null && !"".equals(r.getExecTime())) {
                    r.setExecTime(setTimeFormat(r.getExecTime()));
                }
                if ("0".equals(r.getIsDel())) {
                    r.setIsDel("未删除");
                }
                if ("1".equals(r.getIsDel())) {
                    r.setIsDel("已删除");
                }
            }
        }
        Integer total = tableMapper.selectExecutorHistoryTotal(pageResult);
        List<String> types = tableMapper.getFileType();
        pageResult.setExecutorHistories(list);
        pageResult.setTotal(total);
        pageResult.setTypes(types);
        System.out.println(pageResult);
        return pageResult;
    }

    /**
     * 获取近一个月ECharts数据
     * @return
     */
    @Override
    public ECharts getEChartsDataMonth(ECharts eCharts) {
        List<ECharts> list = eChartsMapper.selectEChartsDataMonth(eCharts);
        return setEChartsList(list);
    }


    /**
     * 对查询到的eCharts统计图所需数据进行处理
     * @param eCharts
     * @return
     */
    private ECharts setEChartsList(List<ECharts> eCharts) {
        if (eCharts.size() == 0) {
            return null;
        }
        ECharts eChartsData = new ECharts();
        Integer seTotal = 0;
        Integer duTotal = 0;
        for (ECharts e: eCharts) {
            seTotal += e.getSeCount();
            duTotal += e.getDuCount();
            eChartsData.getDateForView().add(e.getCreationDate());
            eChartsData.getDateList().add(e.getDate());
            eChartsData.getDuCountList().add(e.getDuCount());
            eChartsData.getSeCountList().add(e.getSeCount());
            eChartsData.getSumCountList().add(e.getSeCount() + e.getDuCount());
        }
        eChartsData.setSeTotal(seTotal);
        eChartsData.setDuTotal(duTotal);
        eChartsData.setTotal(seTotal + duTotal);
        return eChartsData;
    }

    private PageResult setParam(PageResult pageResult, String name) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        pageResult.setPageIndex((pageResult.getPageIndex() - 1) * pageResult.getPageSize());
        if (!"null".equals(pageResult.getStartTime()) && !"".equals(pageResult.getStartTime()) && pageResult.getStartTime() != null &&
                !"null".equals(pageResult.getEndTime()) && !"".equals(pageResult.getEndTime()) && pageResult.getEndTime() != null) {
            pageResult.setStartTime(sdf.format(sdf.parse(pageResult.getStartTime())));
            pageResult.setEndTime(sdf.format(sdf.parse(pageResult.getEndTime())));
        }
        if ("null".equals(pageResult.getFileType()) || pageResult.getFileType() == null) {
            pageResult.setFileType("");
        }
        if ("null".equals(pageResult.getStatus()) || pageResult.getStatus() == null) {
            pageResult.setStatus("");
        }
        if (pageResult.getSortValue() != null && !"".equals(pageResult.getSortValue())) {
            pageResult.setSortValue(pageResult.getSortValue().split("end")[0]);
        } else {
            if ("rapid7".equals(name)) {
                pageResult.setSortName("download_time");
                pageResult.setSortValue("desc");
            }
            if ("record".equals(name)) {
                pageResult.setSortName("start_time");
                pageResult.setSortValue("desc");
            }
            if ("upload".equals(name)) {
                pageResult.setSortName("upload_time");
                pageResult.setSortValue("desc");
            }
            if ("exec".equals(name)) {
                pageResult.setSortName("exec_time");
                pageResult.setSortValue("desc");
            }
        }
        return pageResult;
    }

    private String setFileLength(String fileLength) {
        //BigDecimal.ROUND_HALF_UP表示四舍五入，
        // BigDecimal.ROUND_HALF_DOWN也是五舍六入，
        // BigDecimal.ROUND_UP表示进位处理（就是直接加1），
        // BigDecimal.ROUND_DOWN表示直接去掉尾数
        //1B * 1024 = 1KB * 1024 = 1MB * 1024 = GB
        double length = new BigDecimal(Double.valueOf(fileLength)/1024/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (length < 0.01) {
            //System.out.println(0.01+"MB");
            return "0.01MB";
        } else if (length >= 0.01 && length < 1024) {
            //System.out.println(length+"MB");
            return length+"MB";
        } else {
            length = new BigDecimal(length/1024).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            //System.out.println(length+"GB");
            return length+"GB";
        }
    }

    private String setTimeFormat(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long timeLong = Long.parseLong(time);
        if (time.length() == 10) {
            return sdf.format(timeLong * 1000);
        }
        return sdf.format(timeLong);
    }

}
