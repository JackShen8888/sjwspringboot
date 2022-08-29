package com.ft.ft_asset.entity.xianyu;


// UsedCarClass.java

/**
 * 二手车信息，仅二手车分类传入===
 */
public class UsedCarClass {
    private String reporturl;

    /**
     * 验货报告 URL，示例：https://xx.com/xx.html
     */
    public String getReporturl() { return reporturl; }
    public void setReporturl(String value) { this.reporturl = value; }
}