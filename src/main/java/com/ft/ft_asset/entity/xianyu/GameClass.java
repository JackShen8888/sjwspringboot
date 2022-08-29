package com.ft.ft_asset.entity.xianyu;

// GameClass.java

/**
 * 游戏信息，仅信息分类传入===
 */
public class GameClass {
    private String[] images;
    private String platform;
    private String qcDesc;
    private String qcNo;
    private String title;

    /**
     * 验货图片URL，示例：[xx,xx]
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 游戏平台，示例：任天堂
     */
    public String getPlatform() { return platform; }
    public void setPlatform(String value) { this.platform = value; }

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
     * 验货标题，示例：超级马里奥奥德赛
     */
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
}