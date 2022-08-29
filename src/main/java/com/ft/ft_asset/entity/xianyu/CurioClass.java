package com.ft.ft_asset.entity.xianyu;


// CurioClass.java

/**
 * 文玩信息，仅文玩分类传入====
 */
public class CurioClass {
    private String[] images;
    private String material;
    private long orgid;
    private String qcNo;
    private String size;

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 材质，示例：陶瓷
     */
    public String getMaterial() { return material; }
    public void setMaterial(String value) { this.material = value; }

    /**
     * 检测机构ID，示例：191
     */
    public long getOrgid() { return orgid; }
    public void setOrgid(long value) { this.orgid = value; }

    /**
     * 鉴定编码，示例：3131319
     */
    public String getQcNo() { return qcNo; }
    public void setQcNo(String value) { this.qcNo = value; }

    /**
     * 尺寸，示例：12mmx14mm
     */
    public String getSize() { return size; }
    public void setSize(String value) { this.size = value; }
}