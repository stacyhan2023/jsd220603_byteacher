package cn.tedu.weibo.mapper;

import cn.tedu.weibo.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    /*
    use empdb;
    create table weibo(id int primary key auto_increment,content varchar(100),urls text,
                       created timestamp,user_id int,nick varchar(50));
     */
    @Insert("insert into weibo values(null,#{content},#{urls},#{created},#{userId},#{nick})")
    void insert(Weibo weibo);


    @Select("select id,content,urls,nick from weibo")
    List<Weibo> select();

    @Select("select id,content,urls,nick,created from weibo where id=#{id}")
    Weibo selectById(int id);
}
