package cn.tedu.coolshark.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Product {
    private Integer id;
    private String title;
    private String url;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private Integer num;
    private Integer viewCount; //浏览量
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date created;  //发布时间
    private Integer categoryId; //分类id
    /*
    create table product(id int primary key auto_increment,title varchar(50),
    url varchar(100),price double(10,2),old_price double(10,2),sale_count int,
    num int,view_count int,created timestamp,category_id int);
    * */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", saleCount=" + saleCount +
                ", num=" + num +
                ", viewCount=" + viewCount +
                ", created=" + created +
                ", categoryId=" + categoryId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
