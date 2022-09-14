package cn.tedu.weibo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Weibo {
    private Integer id;
    private String content;
    private String urls;
    //  yyyy-MM-dd HH:mm:ss   yyyy年      MM月  dd日   HH小时  mm分   ss秒
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone = "GMT+8")
    private Date created;//发布时间  导包Java.util
    private Integer userId;//作者id
    private String nick; //作者昵称

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                ", nick='" + nick + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
