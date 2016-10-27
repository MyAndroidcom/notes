### [session生命周期](http://mp.weixin.qq.com/s?src=3&timestamp=1476198564&ver=1&signature=WJm9uHtBrHURp7Oi0fj0HIHf6DqrXluIt6pEncwUr1PAULyj-v9gkuMHPahXhtlBAaYl0FvC*zVK4QaclFnnx*JQcvzLAdm4tL6FGIuU*EcpYMf0WuiijPo8XlEuHb*mgGpmWi7HGzKPNaNsHhPU77vmEi7tZE9IPCJ-B-gFYhM=)
#### 再谈SessionID
- 浏览器客户端的请求，经过Tomcat前端的工作线程池，简单解析socket，初始化Request，传入到Tomcat后端容器的起始位置，CoyoteAdaptor类的service：该类是Tomcat前端和后端容器的一个分水岭，CoyoteAdaptor会基于request进一步的解析，在这个过程中，会查看客户端是否有sessionId，如果有sessionId，那么客户端判定该请求是属于上一次的session会话中，如果没有的，会给这个请求产生一个sessionId：
- 很多人以为，只有我在servlet中调用了request.getSession，这个时候才会有sessionid关联，这个绝对是错误的，sessionid的创建和你客户端怎么写是无关的；
而当你调用request.getSession的时候，实际上是使用是否创建ManagerBase中的session对象的集合：
#### Session生命周期