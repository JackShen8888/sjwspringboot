package com.ft.ft_asset.entity.xianyu;


// Sku.java

public class Sku {
    private String outerid;
    private long price;
    private String skuText;
    private long stock;

    /**
     * 商家SKU编码，示例：317837811-1
     */
    public String getOuterid() { return outerid; }
    public void setOuterid(String value) { this.outerid = value; }

    /**
     * SKU售价（分），示例：199900
     */
    public long getPrice() { return price; }
    public void setPrice(long value) { this.price = value; }

    /**
     * SKU规格，示例：颜色:黑色;容量:128G
     * 注意：规格名称限制4个字符以内，属性值限制20个字符以内
     */
    public String getSkuText() { return skuText; }
    public void setSkuText(String value) { this.skuText = value; }

    /**
     * SKU库存，示例：99
     */
    public long getStock() { return stock; }
    public void setStock(long value) { this.stock = value; }
}