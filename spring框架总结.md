## spring框架总结
### SpringIOC容器
- 作用：创建对象、处理对象的依赖关系
- 创建对象的几种方式：
1)调用无参数构造器
2)带参数构造器
3)工厂对象
```

		<!-- 2. 带参数构造器 -->
		<bean id="user2" class="cn.itcast.b_create_obj.User">
				<constructor-arg index="0" type="int" value="100"></constructor-arg>
				<constructor-arg index="1" type="java.lang.String" value="Jack"></constructor-arg>
			</bean>
			<!-- 3. 工厂类创建对象 -->
	<!-- # 3.1 工厂类，实例方法 -->
				<!-- 先创建工厂 -->
	<bean id="factory" class="cn.itcast.b_create_obj.ObjectFactory"></bean>
		<!-- 在创建user对象，用factory方的实例方法 -->
		<bean id="user4" factory-bean="factory" factory-method="getInstance"></bean>
	
		<!-- # 3.2 工厂类： 静态方法 -->
			<!-- 
	class 指定的就是工厂类型
	factory-method  一定是工厂   里面的“静态方法”
		 -->
       <bean id="user" class="cn.itcast.b_create_obj.ObjectFactory" factory-method="getStaticInstance"></bean>

- 对象依赖关系
Spring中，如何给对象的属性赋值?  【DI, 依赖注入】
	1) 通过构造函数
	2) 通过set方法给属性注入值
	3) p名称空间
	4)自动装配(了解)
	5) 注解
	  (常用)Set方法注入值
	  <!-- dao instance -->
	<bean id="userDao" class="cn.itcast.c_property.UserDao"></bean>

	<!-- service instance -->
	<bean id="userService" class="cn.itcast.c_property.UserService">
		<property name="userDao" ref="userDao"></property>
	</bean>
	
	<!-- action instance -->
	<bean id="userAction" class="cn.itcast.c_property.UserAction">
		<property name="userService" ref="userService"></property>
	</bean>
 内部bean
 <!-- ##############内部bean############## -->
	<bean id="userAction" class="cn.itcast.c_property.UserAction">
		<property name="userService">
			<bean class="cn.itcast.c_property.UserService">
				<property name="userDao">
					<bean class="cn.itcast.c_property.UserDao"></bean>
				</property>
			</bean>
		</property>
	</bean>

- 注解
	1）先引入context名称空间
	xmlns:context="http://www.springframework.org/schema/context"
	2）开启注解扫描
		<context:component-scan base-package="cn.itcast.e_anno2"></context:component-scan>
	3）使用注解
	通过注解的方式，把对象加入ioc容器。

	 创建对象以及处理对象依赖关系，相关的注解：
@Component   指定把一个对象加入IOC容器
@Repository   作用同@Component； 在持久层使用
@Service      作用同@Component； 在业务逻辑层使用
@Controller    作用同@Component； 在控制层使用 
@Resource     属性注入

### IOC总结
通常，每个对象在使用他的合作对象时，自己均要使用像new object（） 这样的语法来完成合作对象的申请工作。你会发现：对象间的耦合度高了。而IOC的思想是：Spring容器来实现这些相互依赖对象的创建、协调工作。对象只需要关系业务逻辑本身就可以了。从这方面来说，对象如何得到他的协作对象的责任被反转了（IOC、DI）。
IOC的一个重点是在系统运行中，动态的向某个对象提供它所需要的其他对象。这一点是通过DI（Dependency Injection，依赖注入）来实现的。比如对象A需要操作数据库，以前我们总是要在A中自己编写代码来获得一个Connection对象，有了 spring我们就只需要告诉spring，A中需要一个Connection，至于这个Connection怎么构造，何时构造，A不需要知道。在系统运行时，spring会在适当的时候制造一个Connection，然后像打针一样，注射到A当中，这样就完成了对各个对象之间关系的控制。A需要依赖 Connection才能正常运行，而这个Connection是由spring注入到A中的，依赖注入的名字就这么来的。那么DI是如何实现的呢？ Java 1.3之后一个重要特征是反射（reflection），它允许程序在运行的时候动态的生成对象、执行对象的方法、改变对象的属性，spring就是通过反射来实现注入的。

### springAOP
#### jdk动态代理

	// 接口
	public interface IUserDao {
		void save();
	}

	public class UserDao implements IUserDao{
		@Override
		public void save() {
			System.out.println("-----已经保存数据！！！------");
		}
	}
	//给所有的dao创建代理对象【动态代理】
	public class ProxyFactory {
		// 维护一个目标对象
		private Object target;
		public ProxyFactory(Object target){
			this.target = target;
		}
		// 给目标对象，生成代理对象  
		public Object getProxyInstance() {
			return Proxy.newProxyInstance(
					target.getClass().getClassLoader(), 
					target.getClass().getInterfaces(),
					new InvocationHandler() {
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							System.out.println("开启事务");
						
						// 执行目标对象方法
						Object returnValue = method.invoke(target, args);
						
						System.out.println("提交事务");
						return returnValue;
					}
				});
	}
       }

     public static void main(String[] args) {
			// 目标对象
	IUserDao target = new UserDao();
			// 【原始的类型 class cn.itcast.b_dynamic.UserDao】
			System.out.println(target.getClass());
		
		// 给目标对象，创建代理对象
		IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
		// class $Proxy0   内存中动态生成的代理对象
		System.out.println(proxy.getClass());
		
		// 执行方法   【代理对象】
		proxy.save();
	}
JDK中生成代理对象的API：
|-- Proxy
	static Object newProxyInstance(
ClassLoader loader,       指定当前目标对象使用类加载器
 Class<?>[] interfaces,     目标对象实现的接口的类型
InvocationHandler h       事件处理器
)  


动态代理总结：
	代理对象不需要实现接口，但是目标对象一定要实现接口；否则不能用动态代理！
	(class  $Proxy0  implements IuserDao)
#### cglib代理
Cglib代理，也叫做子类代理。在内存中构建一个子类对象从而实现对目标对象功能的扩展。

- JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。 
-  CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。 
- CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。

Cglib子类代理：
	1) 需要引入cglib – jar文件， 但是spring的核心包中已经包括了cglib功能，所以直接引入spring-core-3.2.5.jar即可。
	2）引入功能包后，就可以在内存中动态构建子类
	3）代理的类不能为final， 否则报错。
	4） 目标对象的方法如果为final/static, 那么就不会被拦截，即不会执行目标对象额外的业务方法。

在Spring的AOP编程中，
	如果加入容器的目标对象有实现接口，用JDK代理；
	如果目标对象没有实现接口，用Cglib代理；
**AOP编程**
AOP 面向切面的编程，
AOP可以实现“业务代码”与“关注点代码”分离
- Aop，  aspect object programming  面向切面编程
	功能： 让关注点代码与业务代码分离！
- 关注点,
	重复代码就叫做关注点；
切面，
	 关注点形成的类，就叫切面(类)！
	 面向切面编程，就是指对很多功能都有的重复的代码抽取，再在运行的时候网业务方法上动态植入“切面类代码”。
- 切入点，
	执行目标对象方法，动态植入切面代码。
	可以通过切入点表达式，指定拦截哪些类的哪些方法； 给指定的类在运行的时候植入切面类代码。
	bean.xml
	<!-- 开启注解扫描 -->
	<context:component-scan base-package="cn.itcast.e_aop_anno"></context:component-scan>
	<!-- 开启aop注解方式 -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	**使用注解**
	
@Aspect							指定一个类为切面类		
@Pointcut("execution(* cn.itcast.e_aop_anno.*.*(..))")  指定切入点表达式

@Before("pointCut_()")				前置通知: 目标方法之前执行
@After("pointCut_()")					后置通知：目标方法之后执行（始终执行）
@AfterReturning("pointCut_()")		    返回后通知： 执行方法结束前执行(异常不执行)
@AfterThrowing("pointCut_()")			异常通知:  出现异常时候执行
@Around("pointCut_()")				环绕通知： 环绕目标方法执行

// 接口
public interface IUserDao {
	void save();
}
//目标对象
@Component   // 加入容器
public class UserDao implements IUserDao{
	@Override
	public void save() {
		System.out.println("-----核心业务：保存！！！------"); 
	}
}
//切面类
@Component
@Aspect  // 指定当前类为切面类
public class Aop {

	// 指定切入点表单式： 拦截哪些方法； 即为哪些类生成代理对象
	
	@Pointcut("execution(* cn.itcast.e_aop_anno.*.*(..))")
	public void pointCut_(){
	}	
	// 前置通知 : 在执行目标方法之前执行
	@Before("pointCut_()")
	public void begin(){
		System.out.println("开始事务/异常");
	}
	
	// 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
	@After("pointCut_()")
	public void after(){
		System.out.println("提交事务/关闭");
	}
	
	// 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
	@AfterReturning("pointCut_()")
	public void afterReturning() {
		System.out.println("afterReturning()");
	}
	
	// 异常通知： 当目标方法执行异常时候执行此关注点代码
	@AfterThrowing("pointCut_()")
	public void afterThrowing(){
		System.out.println("afterThrowing()");
	}
	
	// 环绕通知：环绕目标方式执行
	@Around("pointCut_()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕前....");
		pjp.proceed();  // 执行目标方法
		System.out.println("环绕后....");
	}
        }

### springMVC
1) 今天说的MVC特指一种表现层设计模式，不限于java语言
#### springMVC快速入门(xml版本)
web.xml配置 
<!-- 注册springmvc框架核心控制器 -->
	<servlet>
		<servlet-name>DispatcherServlet</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>DispatcherServlet</servlet-name>
		<url-pattern>*.action</url-pattern>
	</servlet-mapping>
	Controller层
	ModelAndView modelAndView = new        ModelAndView();
			modelAndView.addObject("message","这是我的第一个springmvc应用程序");
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	
jsp/success.jsp
	<%@ page language="java" pageEncoding="UTF-8"%>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>这是我的第一个springmvc应用程序</title>
  </head>
  <body>
	success.jsp<br/>
	${message}
  </body>
</html>

在/WEB-INF/创建DispatcherServlet-servlet.xml配置文件，xml头部信息与spring.xml相同
<!-- 控制器(程序员) -->
    <bean name="/hello.action" class="cn.itcast.javaee.springmvc.base.HelloAction"></bean>      
    
    <!-- 映射器(框架) -->  
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>  

 <!-- 适配器(框架) -->  
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>  
          
    <!-- 视图解析器(框架) -->  
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"></bean>  

### springMVC
#### 四项配置
- 修改web.xml，添加servlet定义；
- 编写servletname-servlet.xml（servletname是在web.xm中配置DispactherServlet时使servlet-name的值）配置；
- contextConfigLocation初始化参数、配置ContextLoaderListerner；

web.xml
- 在Spring MVC中，Spring Context是以父子的继承结构存在的。Web环境中存在一个ROOT Context，这个Context是整个应用的根上下文，是其他context的双亲Context。同时Spring MVC也对应的持有一个独立的Context，它是ROOT Context的子上下文。
- 对于这样的Context结构在Spring MVC中是如何实现的呢？下面就先从ROOT Context入手，ROOT Context是在ContextLoaderListener中配置的，ContextLoaderListener读取context-param中的contextConfigLocation指定的配置文件，创建ROOT Context。
1. ContextLoaderListener初始化，实例化IoC容器，并将此容器实例注册到ServletContext中；
2.DispatcherServlet初始化；
**Web容器中Spring根上下文的加载与初始化**
Web容器调用contextInitialized方法初始化ContextLoaderListener，在此方法中，ContextLoaderListener通过调用继承自ContextLoader的initWebApplicationContext方法实例化Spring Ioc容器。


 **Spring MVC对应的上下文加载与初始化**
 - Spring MVC中核心的类是DispatcherServlet，在这个类中完成Spring context的加载与创建，并且能够根据Spring Context的内容将请求分发给各个Controller类。DispatcherServlet继承自HttpServlet，关于Spring Context的配置文件加载和创建是在init()方法中进行的，主要的调用顺序是init-->initServletBean-->initWebApplicationContext。
 - 
