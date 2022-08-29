package com.ft.ft_asset.entity.xianyu;

public class ApifoxModal {
    private Empty bookData;
    private String channelCatid;
    private String desc;
    private long districtid;
    private Long expressFee;
    private String[] images;
    private long itemBizType;
    private Long originalPrice;
    private String outerid;
    private long price;
    private ReportDataClass reportData;
    private Sku[] skuItems;
    private long spBizType;
    private String spGuarantee;
    private long stock;
    private Long stuffStatus;
    private String title;

    /**
     * 图书信息，仅图书商品传入
     */
    public Empty getBookData() { return bookData; }
    public void setBookData(Empty value) { this.bookData = value; }

    /**
     * 商品类目ID，示例：e11455b218c06e7ae10cfa39bf43dc0f
     */
    public String getChannelCatid() { return channelCatid; }
    public void setChannelCatid(String value) { this.channelCatid = value; }

    /**
     * 商品描述，注意：不支持HTML代码，可使用\n换行
     */
    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    /**
     * 发货地区ID，示例：440305
     */
    public long getDistrictid() { return districtid; }
    public void setDistrictid(long value) { this.districtid = value; }

    /**
     * 运费（分），示例：100
     */
    public Long getExpressFee() { return expressFee; }
    public void setExpressFee(Long value) { this.expressFee = value; }

    /**
     * 商品图片URL，示例：[xx,xx]（第一张为商品主图）
     */
    public String[] getImages() { return images; }
    public void setImages(String[] value) { this.images = value; }

    /**
     * 商品类型ID，示例：2
     */
    public long getItemBizType() { return itemBizType; }
    public void setItemBizType(long value) { this.itemBizType = value; }

    /**
     * 商品原价（分），示例：299900
     */
    public Long getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(Long value) { this.originalPrice = value; }

    /**
     * 商家编码，示例：317837811
     */
    public String getOuterid() { return outerid; }
    public void setOuterid(String value) { this.outerid = value; }

    /**
     * 商品售价（分），示例：199900（多规格商品，必须是SKU其中一个金额）
     */
    public long getPrice() { return price; }
    public void setPrice(long value) { this.price = value; }

    /**
     * 验货报告信息，仅已验货自检商品类型传入
     */
    public ReportDataClass getReportData() { return reportData; }
    public void setReportData(ReportDataClass value) { this.reportData = value; }

    /**
     * 商品SKU，注意：最多设置两个规格，每个规格限制1~20个属性值
     */
    public Sku[] getSkuItems() { return skuItems; }
    public void setSkuItems(Sku[] value) { this.skuItems = value; }

    /**
     * 商品分类ID，示例：1
     */
    public long getspBizType() { return spBizType; }
    public void setspBizType(long value) { this.spBizType = value; }

    /**
     * 商品标签，示例：1,2（最多设置两个）
     *
     * ------
     * **标签字典:**
     * `1`: 100%验货
     * `2`: 正品鉴别
     * `3`: 七天包退
     * `4`: 一年质保
     * `5`: 48小时发货
     * `7`: 质量问题包退
     * `8`: 一物一证
     */
    public String getspGuarantee() { return spGuarantee; }
    public void setspGuarantee(String value) { this.spGuarantee = value; }

    /**
     * 商品库存，示例：99（多规格商品，必须是SKU库存的合计）
     */
    public long getStock() { return stock; }
    public void setStock(long value) { this.stock = value; }

    /**
     * 商品成色，示例：100（非普通商品类型时必填）
     */
    public Long getStuffStatus() { return stuffStatus; }
    public void setStuffStatus(Long value) { this.stuffStatus = value; }

    /**
     * 商品标题，示例：iPhone 12 128G 黑色
     */
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
}













