<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>待处理纠纷</title>
  <link rel="stylesheet" href="layui/css/layui.css" media="all"> 
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">校园共享服务平台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="111.jsp">待审核任务</a></li>
      <li class="layui-nav-item"><a href="222.jsp">待处理纠纷</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          琛琛
        </a>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">退出系统</a></li>
    </ul>
  </div>
  
    <!-- 内容主体区域 -->
    <div class="layui-body">
    <div class="layui-row">
    <div class="layui-col-xs10">
      <div class="grid-demo grid-demo-bg1"><table class="layui-hide" id="demo" lay-filter="test"></table></div>
    </div>
    <div class="layui-col-xs2">
    </div>
    </div>
  </div>


</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="handle">处理</a>
</script>

<script src="layui/layui.js" charset="utf-8"></script>

<script>
//JavaScript代码区域

layui.use('table', function(){
	var table = layui.table;
	  
	  //第一个实例
	table.render({
	    elem: '#demo'
	    ,height: 624
	    ,url: 'AppealController?method=findAppeal' //数据接口
	    ,id: 'demo'
	  	,skin: 'line' //表格风格
	  	,even: true
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'appealID', title: '投诉单编号', width:120, sort: true}
	      ,{field: 'orderID', title: '订单号', width:120}
	      ,{field: 'complainant', title: '投诉人', width:120}
	      ,{field: 'becomplainant', title: '被投诉人', width:120}
	      ,{field: 'reason', title: '投诉原因', width:200}
	      ,{field: 'descriptions', title: '投诉描述', width: 450}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
	    ]]
	});
	  
	//监听事件
	table.on('tool(test)', function(obj){
		var data = obj.data;
	    if (obj.event=='handle'){
		    obj.del();
			$.ajax({
				type : "post",
				url : 'AppealController?method=setAppealID&appealID=' + data.appealID,
				dataType : "json"
			});
	    }
	});   
});



</script>
</body>
</html>