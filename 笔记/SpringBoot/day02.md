### 商品管理系统步骤:

1. 创建boot02-1工程   
2. 在static里面创建index.html首页页面, 在页面中添加超链接, 请求地址为/insert.html
3. 创建insert.html页面, 页面中有form表单获取用户输入的商品信息,提交地址为/insert
4. 创建controller.ProductController,添加@RestController注解, 添加insert方法处理/insert请求,创建entity.Product实体类,  在insert方法参数列表处声明Product对象 接收传递过来的参数, 控制台输出接收到的product对象, 如果没有问题接下来通过JDBC代码把product对象中的数据保存到product表中 给客户端响应"添加完成! 返回首页"
5. 在首页中添加商品列表超链接, 请求地址为/select ,在Controller中添加select方法处理/select请求,在方法中通过JDBC代码查询到所有商品的信息并把商品信息封装到Product对象中,然后把Product对象装进一个List集合,  最后遍历集合把数据装进一个html字符串中 响应给客户端(可复制粘贴)
6. 在商品列表的表格中添加操作列, 每一行数据添加一个删除超链接, 请求地址为/delete?id=xxx
7. 在Product