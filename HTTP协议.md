#HTTP协议
- http协议： 对浏览器客户端 和  服务器端 之间数据传输的格式规范。内容为：实际上我们输入URL后，我们的浏览器给Web服务器发送了一个Request, Web服务器接到Request后进行处理，生成相应的Response，然后发送给浏览器， 浏览器解析Response中的HTML,这样我们就看到了网页。我们的Request 有可能是经过了代理服务器，最后才到达Web服务器的。
- 代理服务器，中转站功能。
1. 提高访问速度， 大多数的代理服务器都有缓存功能。
2. 突破限制， 也就是翻墙了
3. 隐藏身份。
### HTTP协议是无状态的
　　http协议是无状态的，同一个客户端的这次请求和上次请求是没有对应关系，对http服务器来说，它并不知道这两个请求来自同一个客户端。 为了解决这个问题， Web程序引入了Cookie机制来维护状态。
### Request请求
Request URL:http://monsterhouse.cn/
Request Method:GET
Status Code:200 OK
Remote Address:123.207.5.13:80
### GET请求
- GET提交的数据会放在URL之后，以?分割URL和传输数据，参数之间以&相连，如EditPosts.aspx?name=test1&id=123456.  POST方法是把提交的数据放在HTTP包的Body中.　
- GET提交的数据大小有限制（因为浏览器对URL的长度有限制），而POST方法提交的数据没有限制，不超过1KB。　
- GET方式不适合提交敏感密码。
-  浏览器直接访问的请求，默认提交方式是GET方式。
### POST请求
- 参数不会跟着URI后面。参数而是跟在请求的实体内容中。没有？开头，多个参数之间以&分割。
- POST提交的参数数据没有限制。
- POST方式提交敏感数据。
- POST请求的提交方式，
1）Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
 以multipart/form-data方式提交，以boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW作为分割。一般用来提交带有文件的数据:
 Content-Disposition: form-data; name="ids"

1352521
------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="name"

aaa
2）application/x-www-form-urlencoded
数据格式:
id=12&name=www
3)json数据：Content-Type: application/json

### 请求头
Accept: text/html,image/*      -- 浏览器接受的数据类型
Accept-Charset: ISO-8859-1     -- 浏览器接受的编码格式
Accept-Encoding: gzip,compress  --浏览器接受的数据压缩格式
Accept-Language: en-us,zh-       --浏览器接受的语言
Host: www.it315.org:80          --（必须的）当前请求访问的目标地址（主机:端口）
If-Modified-Since: Tue, 11 Jul 2000 18:23:51 GMT  --浏览器最后的缓存时间
Referer: http://www.it315.org/index.jsp      -- 当前请求来自于哪里
User-Agent: Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)  --浏览器类型
Cookie:name=eric                     -- 浏览器保存的cookie信息
Connection: close/Keep-Alive            -- 浏览器跟服务器连接状态。close: 连接关闭  keep-alive：保存连接。
Date: Tue, 11 Jul 2000 18:23:51 GMT      -- 请求发出的时间
**只有POST提交的参数会放到实体内容中**
**tcp/ip协议关注的是客户端与服务器端的数据是否传输成功**
http协议是在tcp/ip协议之上封装的一层协议，关注数据传输的格式。
**HttpServletRequest**对象作用是用于获取请求数据。
 核心的API：
					请求行： 
						request.getMethod();   请求方式
						request.getRequetURI()   / request.getRequetURL()   请求资源
						request.getProtocol()   请求http协议版本
					请求头：
						request.getHeader("名称")   根据请求头获取请求值
						request.getHeaderNames()    获取所有的请求头名称
						实体内容:
						request.getInputStream()   获取实体内容数据
###  请求参数编码问题
修改POST方式参数编码：
						request.setCharacterEncoding("utf-8");
修改GET方式参数编码：
		 手动解码：String name = new String(name.getBytes("iso-8859-1"),"utf-8");
### http响应过程，request请求到达服务器，携带Request Headers内容如下:
Request URL:http://localhost:8080/scm/buyOrder/insert.action?supId=1&shId=&boDate=2016-08-09&boPayable=12000&boPaid=&boArrears=10000&boOriginal=1231243&boAttn=&boOperator=11&boRemark=11&rows=%5B%7B%22goodsId%22%3A%221%22%2C%22goodsName%22%3A%22note4%22%2C%22goodsUnit%22%3A%22%E9%83%A8%22%2C%22goodsType%22%3Anull%2C%22goodsColor%22%3A%221%22%2C%22bodAmount%22%3A%221%22%2C%22bodBuyPrice%22%3A%2222.00%22%2C%22bodTotalPrice%22%3A22%2C%22bodImeiList%22%3A%223333%22%7D%5D
 Request Method:GET
 Status Code:200 OK
 Remote Address:127.0.0.1:8080
 
Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Accept-Encoding:gzip, deflate, sdch
Accept-Language:zh-CN,zh;q=0.8
Cache-Control:no-cache
Connection:keep-alive
Cookie:JSESSIONID=D683B7556346A7F33A5AE0CD01D9B273; Idea-76965250=69ddc2bf-19fc-4ddb-93f6-5b8afab184bf
Host:localhost:8080
Pragma:no-cache
Referer:http://localhost:8080/scm/base/goURL/buyorder/insert.action
Upgrade-Insecure-Requests:1
User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36
服务器端servlet/spring解析requestHeaders中的内容(基于socket技术)，得到响应的数据。
 
 
	

