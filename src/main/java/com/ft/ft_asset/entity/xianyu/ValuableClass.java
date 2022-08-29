package com.ft.ft_asset.entity.xianyu;


// ValuableClass.java

/**
 * 奢品信息，仅奢品分类传入====
 */
public class ValuableClass {
    private String[] images;
    private long orgid;
    private String qcDesc;
    private String qcNo;

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 检测机构ID，示例：161
     */
    public long getOrgid() { return orgid; }
    public void setOrgid(long value) { this.orgid = value; }

    /**
     * 验货结论，示例：无瑕疵
     */
    public String getQcDesc() { return qcDesc; }
    public void setQcDesc(String value) { this.qcDesc = value; }

    /**
     * 鉴定编码，示例：3131319
     */
    public String getQcNo() { return qcNo; }
    public void setQcNo(String value) { this.qcNo = value; }
}