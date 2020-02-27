<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>注册页面</title>
<link rel="stylesheet" href="z.css" type="text/css" />
</head>
<body>
<div class="container">
    <div class="message signup">
            
       <div class="form--heading">校园共享服务平台</div>
        <div class="form--heading">请来注册一个属于你的账号</div>
    </div>
    
    <div class="form form--signup">
        <div class="form--heading">Welcome! register!</div>
        <form autocomplete="off" action="RegisterController" method="post">
            <input type="text" placeholder="Account" name="account">
            <input type="password" placeholder="Password" name="password">
            <input type="text" placeholder="Nickname" name="nickname">
            <input type="phone" placeholder="Phone" name="phone">
             
            <button class="button" type="submit">确定注册</button>              
        </form>
       
         <a href="login.jsp">
         <button class="button">已有账号，去登录</button>
         </a>
    </div>   
</div>
</body>
</html>