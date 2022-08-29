package com.ft.ft_asset.entity.xianyu;

// VirtualAccountClass.java

/**
 * 虚拟账号/租号信息，仅虚拟账号/租号分类传入====
 */
public class VirtualAccountClass {
    private String[] images;
    private String name;
    private String qcDesc;
    private String qcNo;
    private String title;
    private String type;

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 游戏名称，示例：王者荣耀
     */
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

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
     * 验货标题，示例：王者荣耀王者账号
     */
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    /**
     * 类型，示例：自抽号
     */
    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}