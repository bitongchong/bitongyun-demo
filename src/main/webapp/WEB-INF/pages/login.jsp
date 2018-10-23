<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>笔筒云登录页面</title>
  <link rel="stylesheet" media="screen" href="../static/css/style.css">
  <link rel="stylesheet" type="text/css" href="../static/css/reset.css"/>
</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<form action="/do_login" method="POST">
				<div class="login-center clearfix">
				<div class="login-center-img"><img src="../static/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="user_name" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
				</div>			
				<div class="login-center clearfix">
					<div class="login-center-img"><img src="../static/img/password.png"/></div>
					<div class="login-center-input">
						<input type="password" name="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
						<div class="login-center-input-text">密码</div>
					</div>
				</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" class="login-button"></input>
<!-- 				<div class="register-button">
					<a href="to_register"><font color="white">去注册</font></a>
				</div> -->
				</form>
				</div>
				<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="../static/js/particles.min.js"></script>
<script src="../static/js/app.js"></script>
<script type="text/javascript">
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	}
		document.querySelector(".login-button").onclick = function(){
				addClass(document.querySelector(".login"), "active")
				setTimeout(function(){
					addClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "none"
				},800)
				setTimeout(function(){
					removeClass(document.querySelector(".login"), "active")
					removeClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "block"
					alert("登录成功")
					
				},5000)
		}
</script>
</body>
</html>