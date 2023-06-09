package cn.tedu.weibo.mapper;

import cn.tedu.weibo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id,password,nick from user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);


}
