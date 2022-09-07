package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    //#{变量名}  会自动找到下面方法中参数列表里面的同名参数,
    // 如果没有同名参数的话会调用参数列表中对象的getXXX方法
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);




}
