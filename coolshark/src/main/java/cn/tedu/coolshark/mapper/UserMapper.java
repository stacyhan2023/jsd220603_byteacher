package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select password,nick from user where username=#{username}")
    User selectByUsername(String username);

}
