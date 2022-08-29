package com.ft.ft_asset.entity.xianyu;

// Empty.java

/**
 * 图书信息，仅图书商品传入===
 */
public class Empty {
    private String author;
    private String isbn;
    private String publisher;
    private String title;

    /**
     * 作者，示例：李敖
     */
    public String getAuthor() { return author; }
    public void setAuthor(String value) { this.author = value; }

    /**
     * ISBN码，示例：9787505720176
     */
    public String getIsbn() { return isbn; }
    public void setIsbn(String value) { this.isbn = value; }

    /**
     * 出版社，示例：中国友谊出版公司
     */
    public String getPublisher() { return publisher; }
    public void setPublisher(String value) { this.publisher = value; }

    /**
     * 书名，示例：北京法源寺
     */
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
}