package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select id,name from category ")
    List<Category> select();


}
