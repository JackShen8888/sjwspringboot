package com.ft.ft_asset.entity.xianyu;

// BeautyMakeupClass.java

/**
 * 美妆信息，仅美妆分类传入=====
 */
public class BeautyMakeupClass {
    private String brand;
    private String[] images;
    private String level;
    private long orgid;
    private String spec;

    /**
     * 品牌，示例：欧莱雅
     */
    public String getBrand() { return brand; }
    public void setBrand(String value) { this.brand = value; }

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 成色，示例：全新
     */
    public String getLevel() { return level; }
    public void setLevel(String value) { this.level = value; }

    /**
     * 检测机构ID，示例：181
     */
    public long getOrgid() { return orgid; }
    public void setOrgid(long value) { this.orgid = value; }

    /**
     * 规格，示例：小瓶装
     */
    public String getSpec() { return spec; }
    public void setSpec(String value) { this.spec = value; }
}
