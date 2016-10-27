## [hadoop中RPC实现机制与实例](http://mp.weixin.qq.com/s?src=3&timestamp=1476499641&ver=1&signature=6for6PgpBcIecxywLaY8EU3den6eybC9075BsuLO2IKoiJZSbpfuPoubJNXJOHJ*ycOH74kxMjBEqprSOdEPgQ8Oi0u8sQca5WOfegB*CX6ekv7UYEXR*LsmJGa64mjEA7sl*LulrlCFFul61bDK2A==)
####  RPC原理
- RPC (Remote Procedure Call Protocol) – 远程过程协议调用 。通过 RPC 我们可以从网络上的计算机请求服务，而不需要了 解底层网络协议。 Hadoop 底层的交互都是通过 rpc 进行的。例 如： datanode 和 namenode 、 tasktracker和 jobtracker 、 secondary namenode 和 namenode 之间的通信都是通过 rpc 实 现的。         
- RPC 采用客户机 / 服务器模式。请求程序就是一个客户机， 而服务提供程序就是一个服务器。首先，客户机调用进程发送 一个有进程参数的调用信息到服务进程，然后等待应答信息。 在服务器端，进程保持睡眠状态直到调用信息的到达为止。当一个调用信息到达，服务器获得进程参数，计算结果，发送答 复信息，然后等待下一个调用信息，最后， 客户端调用进程接收答复信息，获得进程结果，然后调用执行继续进行。

#### 服务端流程

- Listener线程监视RPC Client发送过来的数据。
-  当有数据可以接收时，调用Connection的readAndProcess方法。
-   Connection边接收边对数据进行处理，如果接收到一个完整的Call包，则构建一个Call对象。PUSH到Call队列中，由Handler线程来处理Call队列中的所有Call。
-   Handler线程监听Call队列，如果Call队列非空，按FIFO规则从Call队列取出Call。
-   将Call交给RPC.Server处理。 
-  借助JDK提供的Method，完成对目标方法的调用，目标方法由具体的业务逻辑实现。
-  返回响应，Server.Handler按照异步非阻塞的方式向RPC Client发送响应，如果有未发送出的数据，则交由Server.Responder来完成。
