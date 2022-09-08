package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    //#{变量名}  会自动找到下面方法中参数列表里面的同名参数,
    // 如果没有同名参数的话会调用参数列表中对象的getXXX方法
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    //Select注解执行查询相关的SQL语句, 查询到的数据会自动封装到Product对象中并且把
    //多个对象添加到list集合中
    @Select("select * from product")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    void update(Product product);
}
