<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chenglulu.model.Mine"%>
<%@ page import="chenglulu.model.User" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>与我相关</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body bgcolor="#f2f2f2">
<script src="layui/layui.js"></script>
<script>
	layui.use('element', function(){
	    var element = layui.element;
	
	    //…
	});
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
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#test1'
            ,height: 312
            ,url: 'GetMineController?method=getMyrelease' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
            	{field: 'orderID', title: '订单号', hide: true}
                ,{field: 'title', title: '标题', width:120, sort: true}
                ,{field: 'orders_type', title: '任务类型', width:80}
                //,{field: 'publisher', title: '发布人', width:100}               
                ,{field: 'startTime', title: '开始时间', width:120}
                ,{field: 'endTime', title: '结束时间', width:120, sort: true}
                ,{field: 'cost', title: '费用', width:60}
                ,{field: 'description', title: '具体描述', width:160}
                ,{field: 'receiver', title: '收货人', width: 100}
                ,{field: 'receivePhone', title: '收货电话', width: 100, sort: true}
                ,{field: 'receivePlace', title: '收货地址', width: 150, sort: true}
                ,{field: 'orders', title: '接单人', width: 100}
                ,{field: 'right', title: '操作', width: 80, toolbar:'#barDemo'}
            ]]
        }); 
        
         table.render({
        	 elem: '#test2'
             ,height: 312
             ,url: 'GetMineController?method=getMyOrders' //数据接口
             ,page: true //开启分页
             ,cols: [[ //表头
            	{field: 'orderID', title: '订单号', hide: true}
                ,{field: 'title', title: '标题', width:120, sort: true}
                ,{field: 'orders_type', title: '任务类型', width:100}
                ,{field: 'publisher', title: '发布人', width:100}               
                ,{field: 'startTime', title: '开始时间', width:120}
                ,{field: 'endTime', title: '结束时间', width:120, sort: true}
                ,{field: 'cost', title: '费用', width:60}
                ,{field: 'description', title: '具体描述', width:160}
                ,{field: 'receiver', title: '收货人', width: 100}
                ,{field: 'receivePhone', title: '收货电话', width: 100, sort: true}
                ,{field: 'receivePlace', title: '收货地址', width: 150, sort: true}
                //,{field: 'orders', title: '接单人', width: 100}
                ,{field: '', title: '操作', width: 80, toolbar:'#barDemo2'}
                //,{field: '', title: '操作', template:toolbar, align:"center", width: 100, toolbar:'#bar'}
            ]]
        }); 
        
       table.render({
            elem: '#test3'
            ,height: 312
            ,url: 'GetMineController?method=getMyAppeal' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'appealID', title: '投诉单号', hide: true}
                ,{field: 'orderID', title: '订单编号', width:200, sort: true}
                ,{field: 'reason', title: '投诉原因', width:300}
                ,{field: 'descriptions', title: '描述', width:1000}  
                ,{field: '', title: '操作', width: 80, toolbar:'#barDemo3'}
                //,{field: '', title: '操作', template:toolbar, align:"center", width: 100, toolbar:'#bar'}
             ]]
         }); 
       
       //监听事件
   	table.on('tool(test1)', function(obj){
   		var data = obj.data;
   	    if (obj.event=='handle1'){ 		    
   			$.ajax({
   				type : "post",
   				data: {
   					"orderID":data.orderID,
   					"orders":data.orders
   				},
   				url : 'AppealController?method=dispatcherRelease',
   				dataType : "json"
   			});
   			obj.del();
   			//layer.msg("处理成功！");
   	    }
   	});     
    
     
   //监听事件
   	table.on('tool(test2)', function(obj){
   		var data = obj.data;
   	    if (obj.event=='handle2'){
   		    
   			$.ajax({
   				type : "post",
   				data: {
   					"orderID":data.orderID,
   					"publisher":data.publisher
   				},
   				url : '/appeal.jsp',
   				dataType : "json"
   			});
   			obj.del();
   	    }
   	});   
  
     //监听事件
   	table.on('tool(test3)', function(obj){
   		var data = obj.data;
   	    if (obj.event=='cancel'){
   		    obj.del();
   			$.ajax({
   				type : "post",
   				url : 'AppealController?method=cancelAppeal&appealID='+data.appealID,
   				dataType : "json"
   			});
   	    }
   	});    
});
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="handle1">投诉</a>
</script>
<script type="text/html" id="barDemo2">
  <a class="layui-btn layui-btn-xs" lay-event="handle2">投诉</a>
</script>
<script type="text/html" id="barDemo3">
  <a class="layui-btn layui-btn-xs" lay-event="cancel">取消</a>
</script>
<!--顶部导航栏-->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">校园共享服务平台</div>
        <ul class="layui-nav layui-layout-left" >
            <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item "><a href="orders.jsp">任务池</a></li>
            <li class="layui-nav-item"><a href="release.jsp">任务发布</a></li>
        </ul><ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item layui-this" >
            <a href="javascript:;"><i class="layui-icon layui-icon-username"></i>我</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="myinformation.jsp">与我相关</a> </dd>
                <dd><a href="changeinformation.jsp">修改信息</a></dd>
                <dd><a href="login.jsp">退出登录</a></dd>
            </dl>
        </li>v
        <li class="layui-nav-item" ><a href=""><i class="layui-icon layui-icon-notice"></i><span class="layui-badge-dot"></span></a> </li>
    </ul>

    </div>

</div>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>我的发布</legend>
    </fieldset>
    <table class="layui-table" id="test1" lay-filter="test1"></table>
</div>

<br><br>
<div class="layui-container" >
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>我的接单</legend>
    </fieldset>
    <table class="layui-table" id="test2" lay-filter="test2"></table>
</div>

<br><br>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>我的申诉</legend>
    </fieldset>
    <table class="layui-table" id="test3" lay-filter="test3"></table>
</div>

</body>
</html>