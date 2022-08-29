package com.ft.ft_asset.entity.xianyu;


// JewelryClass.java

/**
 * 珠宝信息，仅珠宝分类传入===
 */
public class JewelryClass {
    private String color;
    private String[] images;
    private String orgName;
    private String qcDesc;
    private String qcNo;
    private String shape;
    private String weight;

    /**
     * 颜色，示例：白色
     */
    public String getColor() { return color; }
    public void setColor(String value) { this.color = value; }

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 检测机构，示例：某某平台
     */
    public String getOrgName() { return orgName; }
    public void setOrgName(String value) { this.orgName = value; }

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

    /**
     * 形状，示例：圆形
     */
    public String getShape() { return shape; }
    public void setShape(String value) { this.shape = value; }

    /**
     * 重量，示例：125g
     */
    public String getWeight() { return weight; }
    public void setWeight(String value) { this.weight = value; }
}