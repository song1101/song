<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>���������</title>
  <link rel="stylesheet" href="layui/css/layui.css" media="all"> 
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">У԰�������ƽ̨</div>
    <!-- ͷ�����򣨿����layui���е�ˮƽ������ -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="111.jsp">���������</a></li>
      <li class="layui-nav-item"><a href="222.jsp">���������</a></li>
      
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ��
        </a>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">�˳�ϵͳ</a></li>
    </ul>
  </div>
  
  <br><br><br><br><br>
    <!-- ������������ -->
    <div class="layui-row">
    <table class="layui-hide" id="demo" lay-filter="test"></table>
    </div>


</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="pass">���ͨ��</a>
</script>

<script src="layui/layui.js" charset="utf-8"></script>

<script>
//JavaScript��������

layui.use('table', function(){
	  var table = layui.table;
	  
	  //��һ��ʵ��
	  table.render({
	    elem: '#demo'
	    ,url: 'OrderServlet?method=adminOrder' //���ݽӿ�
	    ,page: true //������ҳ
		,skin: 'line' //�����
		,even: true
	    ,cols: [[ //��ͷ
	      {field: 'orderID', title: '������', hide:true}
	      ,{field: 'title', title: '����', width:120}
	      ,{field: 'orders_type', title: '��������', width:100}
	      
	      ,{field: 'publisher', title: '������', width:100}
	      ,{field: 'startTime', title: '��ʼʱ��', width:120, sort: true} 
	      ,{field: 'endTime', title: '����ʱ��', width:120}
	      ,{field: 'receiver', title: '�ջ���', width:100}
	      ,{field: 'receivePhone', title: '�ջ��绰', width:100}
	      ,{field: 'receivePlace', title: '�ջ��ص�', width:150}
	      ,{field: 'cost', title: '����', width: 70}
	      ,{field: 'description', title: '����', width: 360}
	      ,{fixed: 'right', title:'����', toolbar: '#barDemo', width:150}
	    ]]
	  });
	  
	 //�����¼�
		table.on('tool(test)', function(obj){
			var data = obj.data;
		    if (obj.event=='pass'){
			    
				$.ajax({
					type : "post",
					url : 'OrderServlet?method=setIsCheck&orderID=' + data.orderID,
					dataType : "json"
				});
				obj.del();
				//layer.msg("����ɹ���");
		    }
		});    
});
	</script>
</body>
</html>