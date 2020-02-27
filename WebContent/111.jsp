<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>待审核任务</title>
  <link rel="stylesheet" href="layui/css/layui.css" media="all"> 
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
  
  <br><br><br><br><br>
    <!-- 内容主体区域 -->
    <div class="layui-row">
    <table class="layui-hide" id="demo" lay-filter="test"></table>
    </div>


</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="pass">审核通过</a>
</script>

<script src="layui/layui.js" charset="utf-8"></script>

<script>
//JavaScript代码区域

layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,url: 'OrderServlet?method=adminOrder' //数据接口
	    ,page: true //开启分页
		,skin: 'line' //表格风格
		,even: true
	    ,cols: [[ //表头
	      {field: 'orderID', title: '订单号', hide:true}
	      ,{field: 'title', title: '标题', width:120}
	      ,{field: 'orders_type', title: '任务类型', width:100}
	      
	      ,{field: 'publisher', title: '发布人', width:100}
	      ,{field: 'startTime', title: '开始时间', width:120, sort: true} 
	      ,{field: 'endTime', title: '结束时间', width:120}
	      ,{field: 'receiver', title: '收货人', width:100}
	      ,{field: 'receivePhone', title: '收货电话', width:100}
	      ,{field: 'receivePlace', title: '收货地点', width:150}
	      ,{field: 'cost', title: '费用', width: 70}
	      ,{field: 'description', title: '描述', width: 360}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
	    ]]
	  });
	  
	 //监听事件
		table.on('tool(test)', function(obj){
			var data = obj.data;
		    if (obj.event=='pass'){
			    
				$.ajax({
					type : "post",
					url : 'OrderServlet?method=setIsCheck&orderID=' + data.orderID,
					dataType : "json"
				});
				obj.del();
				//layer.msg("处理成功！");
		    }
		});    
});
	</script>
</body>
</html>