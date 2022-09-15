package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select id,name from category ")
    List<Category> select();

    @Delete("delete from category where id=#{id}")
    void deleteById(int id);

    @Insert("insert into category values(null,#{name})")
    void insert(String name);

    @Update("update category set name=#{name} where id=#{id}")
    void update(Category category);

}
