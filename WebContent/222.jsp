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
  
    <!-- ������������ -->
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
  <a class="layui-btn layui-btn-xs" lay-event="handle">����</a>
</script>

<script src="layui/layui.js" charset="utf-8"></script>

<script>
//JavaScript��������

layui.use('table', function(){
	var table = layui.table;
	  
	  //��һ��ʵ��
	table.render({
	    elem: '#demo'
	    ,height: 624
	    ,url: 'AppealController?method=findAppeal' //���ݽӿ�
	    ,id: 'demo'
	  	,skin: 'line' //�����
	  	,even: true
	    ,page: true //������ҳ
	    ,cols: [[ //��ͷ
	      {field: 'appealID', title: 'Ͷ�ߵ����', width:120, sort: true}
	      ,{field: 'orderID', title: '������', width:120}
	      ,{field: 'complainant', title: 'Ͷ����', width:120}
	      ,{field: 'becomplainant', title: '��Ͷ����', width:120}
	      ,{field: 'reason', title: 'Ͷ��ԭ��', width:200}
	      ,{field: 'descriptions', title: 'Ͷ������', width: 450}
	      ,{fixed: 'right', title:'����', toolbar: '#barDemo', width:100}
	    ]]
	});
	  
	//�����¼�
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