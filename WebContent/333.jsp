<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>待处理纠纷</title>
  <link rel="stylesheet" href="layui/css/layui.css" media="all"> 
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">校园共享服务平台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="111.jsp">待审核任务</a></li>
      <li class="layui-nav-item"><a href="222.jsp">待处理纠纷</a></li>
      <li class="layui-nav-item"><a href="333.jsp">用户意见</a></li>
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
      <div class="grid-demo grid-demo-bg1"><table class="layui-hide" id="demo"></table></div>
    </div>
    <div class="layui-col-xs2">
    </div>
    </div>
  </div>


</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">我已知晓</a>
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
	    ,url: 'SuggestServlet' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: '1', title: '意见编号', width:150, sort: true, fixed: 'left'}
	      ,{field: '2', title: '意见人', width:80}
	      ,{field: 'descriptions', title: '详情', width: 780}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100, fixed: 'right'}
	    ]]
	  ,data: [{
	      "1": "1"
	      ,"2": "方琛"
	      ,"descriptions": "希望你们的界面可以做的更好看一些"
	  },{"1": "2"
	      ,"2": "肖战"
	      ,"descriptions": "滴滴滴"
	  }]  
	  ,skin: 'line' //表格风格
	  ,even: true
	  });
	  
	});
	</script>
</body>
</html>