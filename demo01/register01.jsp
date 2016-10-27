<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- AJAX是一个【局部刷新】的【异步】通讯技术
	    AJAX不是全新的语言，是2005年Google公司推出的一种全新【编程模式】，不是新的编程语言
 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>基于HTML，以GET或POST方式，检查注册用户名是否在数据库中已存在</title>
</head>
<body>
	<form>
		用户名[GET]：<input id="usernameID" type="text" name="username" maxlength="4"/>
		光标移出后，立即检查结果
	</form><p/>
	<span id="resID"></span>

	<script type="text/javascript">
		//创建AJAx异步对象
		function createAJAX(){
			var ajax = null;
			try{
				//IE
				ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch (e) {
				// 非IE
				try{
					ajax = new XMLHttpRequest();
				}
				catch (e) {
					alert("你的浏览器不支持AJAX")
				}
			}
			return ajax;
		}
	</script>
	<script type="text/javascript">
		document.getElementById("usernameID").onblur=function(){

	}
	</script>
</body>
</html>