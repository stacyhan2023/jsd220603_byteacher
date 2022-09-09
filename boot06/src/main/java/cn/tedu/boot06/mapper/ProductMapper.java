package cn.tedu.boot06.mapper;

import cn.tedu.boot06.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("select * from product")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select * from product where id=#{id}")
    Product selectById(int id);
}
