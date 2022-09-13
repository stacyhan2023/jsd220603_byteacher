package cn.tedu.boot07.mapper;

import cn.tedu.boot07.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    //create table image(id int primary key auto_increment,intro varchar(100),urls text);
    @Insert("insert into image values(null,#{intro},#{urls})")
    void insert(Image image);


    @Select("select * from image")
    List<Image> select();



}
