package com.grandeflorum.statistic.domain;

/**
 * Created by 13260 on 2019/12/1.
 */
public class StatisticValue {

    private String dateValue;

    /**
     * 租金
     */
    private double zj;

    /**
     * 套数
     */
    private double ts;

    /**
     * 行政区划名
     */
    private String regionName;

    public String getDateValue() {
        return dateValue;
    }

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }

    public double getZj() {
        return zj;
    }

    public void setZj(double zj) {
        this.zj = zj;
    }

    public double getTs() {
        return ts;
    }

    public void setTs(double ts) {
        this.ts = ts;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}