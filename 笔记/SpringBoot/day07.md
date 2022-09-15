### 酷鲨商城项目步骤:

1. 创建工程coolshark  打3个勾  
2. 在application.properties配置文件中添加连接数据库信息
3. 把老师工程中四个页面和imgs文件夹赋值到新工程中, 然后鼠标选中static 按下ctrl+shift+f9重新编译  然后再运行 访问首页,能够正常显示即可

4. 建库建表

create database cs charset=utf8; 

use cs; 

create table user(id int primary key auto_increment,username varchar(50),password  varchar(50),nick varchar(50));

 insert into user values(null,'admin','123456','管理员');

### 登录功能步骤: 

1. 在 login.html 中给登录按钮添加点击事件 点击时调用 login 方法,并且在 data 里面声明一个 user 对象让页面中的文本框和密码框和 user 对象里面的用户名和密码进行双向绑定,实现 login 方法在方法中向/login 发出请求,根据响应的 123 控制显示的内容,如果是 1 代表成功 跳转到首页 

2. 创建 User 实体类,创建 UserMapper 在 mapper 中提供一个 selectByUsername 方法 

3. 创建 UserController 添加 login 方法处理/login 请求, 调用 mapper 里面的方法 给客户端响 应 1,2,3

