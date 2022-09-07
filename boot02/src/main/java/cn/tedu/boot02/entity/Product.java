package cn.tedu.boot02.entity;

public class Product {
    private Integer id;
    private String title;
    private Double price;
    private Integer num;

    public Product() {
    }

    public Product(Integer id, String title, Double price, Integer num) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
    }
// 包装类型有null值 比基本数据类型多了一个未赋值的状态
    /*
    use empdb;
    create table product(id int primary key auto_increment,
                        title varchar(50),price double(10,2),
                        num int);
    * */

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
