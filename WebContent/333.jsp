<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>���������</title>
  <link rel="stylesheet" href="layui/css/layui.css" media="all"> 
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">У԰�������ƽ̨</div>
    <!-- ͷ�����򣨿����layui���е�ˮƽ������ -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="111.jsp">���������</a></li>
      <li class="layui-nav-item"><a href="222.jsp">���������</a></li>
      <li class="layui-nav-item"><a href="333.jsp">�û����</a></li>
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
      <div class="grid-demo grid-demo-bg1"><table class="layui-hide" id="demo"></table></div>
    </div>
    <div class="layui-col-xs2">
    </div>
    </div>
  </div>


</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">����֪��</a>
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
	    ,url: 'SuggestServlet' //���ݽӿ�
	    ,page: true //������ҳ
	    ,cols: [[ //��ͷ
	      {field: '1', title: '������', width:150, sort: true, fixed: 'left'}
	      ,{field: '2', title: '�����', width:80}
	      ,{field: 'descriptions', title: '����', width: 780}
	      ,{fixed: 'right', title:'����', toolbar: '#barDemo', width:100, fixed: 'right'}
	    ]]
	  ,data: [{
	      "1": "1"
	      ,"2": "���"
	      ,"descriptions": "ϣ�����ǵĽ���������ĸ��ÿ�һЩ"
	  },{"1": "2"
	      ,"2": "Фս"
	      ,"descriptions": "�εε�"
	  }]  
	  ,skin: 'line' //�����
	  ,even: true
	  });
	  
	});
	</script>
</body>
</html>