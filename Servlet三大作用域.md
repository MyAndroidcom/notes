## Servlet三大作用域
#### request
request是表示一个请求，只要发出一个请求就会创建一个request，它的作用域：仅在当前请求中有效,常用于服务器间同一请求不同页面之间的参数传递。
方法：request.setAttribute(); request.getAttribute(); request.removeAttribute(); request.getParameter().
String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
#### session
服务器会为每个会话创建一个session对象，所以session中的数据可供当前会话中所有servlet共享。
会话：用户打开浏览器会话开始，直到关闭浏览器会话才会结束。一次会话期间只会创建一个session对象。
用处：常用于web开发中的登陆验证界面（当用户登录成功后浏览器分配其一个session键值对）。
方法：session.setAttribute(); session.getAttribute(); session.removeAttribute();
	    User user = new User();
        user.setPassword(passwd);
        user.setName(name);
 request.getSession().setAttribute("user",user);
   welcome, ${user.name}
   获得session对象方法
 1，在Servlet中：HttpSession session = request.getSession();
 2，由于session属于jsp九大内置对象之一，当然可以直接使用。例如：<%session.serAttribute("name","admin")%>。
 备注： session是服务器端对象，保存在服务器端。并且服务器可以将创建session后产生的sessionid通过一个cookie返回给客户端，以便下次验证。
#### application
作用范围：所有的用户都可以取得此信息，此信息在整个服务器上被保留。Application属性范围值，只要设置一次，则所有的网页窗口都可以取得数据。ServletContext在服务器启动时创建，在服务器关闭时销毁，一个JavaWeb应用只创建一个ServletContext对象。
获取Application对象方法（Servlet中）：  
 ServletContext app01 = this.getServletContext();
     app01.setAttribute("name", "kaixuan");    //设置一个值进去
 ServletContext app02 = this.getServletContext();
     app02.getAttribute("name");    //获取键值对  
     ServletContext同属于JSP九大内置对象之一，故可以直接使用
备注：服务器只会创建一个ServletContext 对象，所以app01就是app02，通过app01设置的值当然可以通过app02获取。

## [servlet九大内置对象](http://mp.weixin.qq.com/s?src=3&timestamp=1476012857&ver=1&signature=GA7Hy*60xPPEXqb8Rl5obqQWuC9xAx6CpqMA9NZZVzIDSnwB7x23mpVbKVUAonXylHQFcHmuxo67bPH22pNU-6Ct*1WBea6zLGXAyiEO3fb*paPB91JdtCGozp-LlLvVczjDthTzzEJN3yjRuvz*A6ECiYuj426BP3ZDi-XKVsY=)

### request内置对象
它代表的是java.servlet.HttpServletRequest类的对象。request内置对象中包含了有关浏览器请求的信息，并提供了多个用于获取cookie、header以及session内数据的方法。
- u  getMethod()：返回HTTP请求信息中所使用到的方法名称；
u  getServletPath()：返回请求信息中调用Servlet的URL部分；
u  getQueryString()：返回HTTP GET请求信息中URL之后的查询字符串；
u  getContentType()：返回请求实体的MIME类型；
u  getProtocol()：返回请求信息中的协议名名字与版本号；
u  getPathInfo()：返回有关任何路径信息；
u  getServletName()：返回接受请求的服务器主机；
u  getServletPort()：返回服务器的端口号；
u  getRemoteHost()：返回提交请求的客户机的规范名字；
u  getRemoteAddr()：返回提交请求的客户机的IP地址；
u  getScheme()：返回请求使用的模式（协议）名字；
u  getParameter()：返回客户端通过表单提交过来的参数值。例如request.getParameter(“myname”)，通过该语句来获取客户端传递过来的myname 参数。
u  getContextPath()：返回HTTP 请求中指示请求上下文的部分。
### response 内置对象
setContentType(String type)：用于设置HTTP响应的contentType中的MIME类型，其中可以包含字符编码的规则。例如可以把contentType设置为“text/html;charset=GBK”。在Servelet编写过程中，需要调用此方法进行设置，但是在JSP中一般都是使用page指令直接指定contentType的属性.
 getOutputStream()：此方法返回一个Servlet的输出流。用于在响应中写入二进制数据。Servlet容器不对二进制数据进行编码。
 sendRedirect(String location)：将请求重新定位到一个不同的URL（页面）上。此方法在实际开发过程中会经常使用到。
 response.sendRedirect('hello.jsp'); //则页面重定向为hello.jsp
 eg:  response响应一个html页面
 PrintWriter out =   response.getWriter(); //调用HttpServletResponse类中的getWriter()方法。
    out.println('<table   border='0' cellpadding='0' cellspacing='0' width='150'>');
    out.println('<tr><td   height='5'>这是HttpServletResponse类中的getWriter()方法的例子</td></tr>');
      out.println('</table>');
      

### page内置对象
 getClass()：返回当时Object的类。
hashCode()：返回此Object的哈希代码。
toString()：把此时的Object类转换成字符串。
equals(Object o)：比较此对象是否和指定的对象是否相等。
copy（Object o）：把此对象复制到指定的对象当中去。
clone()：对此对象进行克隆。     

###  session内置对象
Java Servlet提供了一个可以在多个请求之间持续有效的会话对象HttpSession，此对象允许用户存储和提取会话状态的信息。JSP同样也支持了Servlet中的这个概念。JSP中的session内置对象就是对应于Servlet中的HttpSession对象。当Web应用系统希望通过多个页面完成一个事务的时候，session的使用是非常有用和方便的。
 getMaxInactiveInterval()：返回总时间（秒），负值表示session永远不会超时。
  getAttribute(String   key)：通过给定的关键字获取一个存储在session中相对应的信息。例如，Integer item = (Integer)   session.getAttrobute('item')。
     setAttribute(String   key, Object obj)：提供一个关键词和一个对象值，然后存在session当中。例如，session.setAttribute('ItemValue', itemName)。
 
<%
    String username =   request.getParameter('username'); //获得传递参数username
      session.setAttribute('theusername',username); //把用户名保存在session中，String可以当着对象
%>