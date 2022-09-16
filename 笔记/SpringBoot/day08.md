### 后台商品列表展示步骤:

1. 在admin.html页面中删除数组中的假数据, 在created方法中向/product/select发请求获取商品信息把得到的商品信息给到productArr数组
2. 在ProductController里面添加select方法处理/product/select请求 调用mapper里面的select方法把返回的集合直接响应给客户端
3. 实现mapper中的 select方法

### 表字段和属性字段不一致解决方案:

1. 通过别名(这种用法不能复用不推荐)

2. 通过@Result注解  

3. 通过在application.properties里面添加配置信息

   