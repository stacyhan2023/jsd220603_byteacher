package cn.tedu.weibo.mapper;

import cn.tedu.weibo.entity.Comment;
import cn.tedu.weibo.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    /*
 create table comment(id int primary key auto_increment,
                    content varchar(100),nick varchar(50),
                    weibo_id int);
    */

    @Insert("insert into comment values(null,#{content},#{nick},#{weiboId})")
    void insert(Comment comment);

    @Select("select id,content,nick from comment where weibo_id=#{id}")
    List<Comment> selectByWeiboId(int id);

}
