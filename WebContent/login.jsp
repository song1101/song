<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>登录页面</title>
<link rel="stylesheet" href="z.css" type="text/css" />
</head>
<body>
<div class="container">
    <div class="message signup">
         <div class="form--heading">校园共享服务平台</div>
          <div class="form--heading">欢迎来到登录界面</div>
    </div>
 
    
    <div class="form form--login">
        <div class="form--heading">Welcome! login! </div>
        <form autocomplete="off" action="LoginController" method="post">
            <input type="text" placeholder="Name" name="account">
            <input type="password" placeholder="Password" name="password">
            <div class="form--heading">
            	<div style="display:inline;float:left"><input type="radio" name="quest" value="1">学生</div>
            	<div style="display:inline;float:left"><input type="radio" name="quest" value="2">管理员</div>
            </div>
            <button class="button">确定登录</button>
        </form>
        <a href="signup.jsp">
         <button class="button">没有账号，去注册</button>
         </a>
    </div>
    
</div>
</body>
</html>