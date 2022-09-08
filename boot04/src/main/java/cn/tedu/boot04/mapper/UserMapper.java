package cn.tedu.boot04.mapper;

import cn.tedu.boot04.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //通过User对象接收查询回来的id  如果查不到 方法返回的是个null
    @Select("select id from user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);



}
