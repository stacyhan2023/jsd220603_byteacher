### Mybatis版本的商品管理系统

### Mybatis版本的注册登录

### 同步请求和异步请求

- 同步:指单线程依次做几件事
- 异步:指多线程同时做几件事   
- 同步请求: 指客户端只有一个主线程, 主线程既要负责页面展示相关,也需要负责发请求获取数据,由于只有一个线程,当获取数据时不能同时显示着内容(清空页面), 当服务器把数据响应回来之后再次显示内容, 这样的话只能实现页面的整体改变(整体刷新),无法实现页面的局部刷新.
- 异步请求: 指客户端由主线程负责页面展示相关, 由子线程负责发请求获取数据,这样的话主线程只负责展示页面相关,页面内容就不需要清空, 子线程得到数据后可以在原页面的基础上做改动,这种就叫做页面的局部刷新.

### 客户端如何发出异步请求? 

- 通过Axios框架发出异步请求 

- Axios框架是一个前端js框架, 使用此框架的话需要在html页面中引入 axios.js文件

  https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js



### GET和POST

localhost:8080/helloAxios?username=tomg&password=123456&nick=汤姆

- GET: 请求参数在请求地址的后面, 由于参数在地址中可见所以不能传递敏感信息, 参数大小有限制只能传递几k的数据
  - 应用场景: 一般情况下查询请求都是用Get请求, 删除数据一般也使用get请求
- POST:请求参数是在请求体里面,  由于参数在请求体中,用户不可见所以可以传递敏感信息,没有大小的限制

​			- 应用场景:  因为参数是写在请求地址后面通过拼接的方式传递参数,如果参数较多推荐使用post请求, 参数中包含敏感信息时使用,  上传文件时使用