<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>投诉</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body bgcolor="#f2f2f2">
<script src="layui/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来进行渲染
        form.render();
    });
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#stime'//指定元素
            ,theme: '#393D49'
        });
        laydate.render({
            elem: '#etime'//指定元素
            ,theme: '#393D49'
        });
    });
</script>
<!--顶部导航栏-->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">校园共享服务平台</div>
        <ul class="layui-nav layui-layout-left" >
            <li class="layui-nav-item"><a href="index.html">首页</a></li>
            <li class="layui-nav-item "><a href="orders.html">任务池</a></li>
            <li class="layui-nav-item "><a href="release.html">任务发布</a></li>
        </ul><ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item" >
            <a href="javascript:;"><i class="layui-icon layui-icon-username"></i>我</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="myinformation.html">与我相关</a> </dd>
                <dd><a href="changeinformation.html">修改信息</a></dd>
                <dd><a href="login.jsp">退出登录</a></dd>
            </dl>
        </li>v
        <li class="layui-nav-item" ><a href=""><i class="layui-icon layui-icon-notice"></i><span class="layui-badge-dot"></span></a> </li>
    </ul>

    </div>

</div>

<!--表单-->
<br><br><br>

<div class="layui-anim layui-anim-scale">

	<form action="AppealController?method=setAppeal" method="post">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md4">

        </div>
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header">投诉详情填写</div>
                <div class="layui-card-body">
                    <div class="layui-form">
                        <!-- <div class="layui-form-item">
                            <label class="layui-form-label">订单编号</label>
                            <div class="layui-input-block">
                                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="title">
                            </div>
                        </div> -->
                        <div class="layui-form-item">
                            <label class="layui-form-label">投诉原因</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" class="layui-textarea" id="description" name="reason"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">投诉描述</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" class="layui-textarea" id="description" name="descriptions"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item " >
                            <div class="layui-input-block">
                                <button type="submit" class="layui-btn" >立即提交</button>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                <button type="reset"  class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</form>
        <div class="layui-col-md4">

        </div>
    </div>

</div>


</body>
</html>