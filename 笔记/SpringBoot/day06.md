### Session会话

- 服务器端会为每一个客户端创建一个会话对象, 此会话对象里面可以保存数据,保存的数据可以在同一客户端的多次请求中共享

### 如何实现记住登录状态?

- 在登录成功时,将登录成功的user对象保存到当前客户端对应的Session对象里面
- 从Session对象里面获取user对象如果获取到了代表登录成功, 如果没有获取到代表未登录

### 如何实现退出登录状态?

- 将当前客户端对应的Session对象里面的user对象删除,就代表了退出登录

