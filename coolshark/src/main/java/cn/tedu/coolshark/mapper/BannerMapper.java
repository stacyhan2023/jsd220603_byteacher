package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.Banner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select id,url from banner")
    List<Banner> select();

    @Delete("delete from banner where id=#{id}")
    void deleteById(int id);


}
