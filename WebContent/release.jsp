<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>任务发布</title>
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
            <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item "><a href="orders.jsp">任务池</a></li>
            <li class="layui-nav-item layui-this"><a href="release.jsp">任务发布</a></li>
        </ul><ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item" >
            <a href="javascript:;"><i class="layui-icon layui-icon-username"></i>我</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="myinformation.jsp">与我相关</a> </dd>
                <dd><a href="changeinformation.jsp">修改信息</a></dd>
                <dd><a href="">退出登录</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item" ><a href=""><i class="layui-icon layui-icon-notice"></i><span class="layui-badge-dot"></span></a> </li>
    </ul>

    </div>

</div>

<!--表单-->
<br><br><br>
<div class="layui-anim layui-anim-scale">
	<div class="layui-row layui-col-space10">
		<div class="layui-col-md4">
		</div>
		<div class="layui-col-md4">
 			<div class="layui-card">
				<div class="layui-card-header">任务清单填写</div>
					<div class="layui-card-body">
                    	<div class="layui-form">
                    		<form action="PublishController" method="post">
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">标题</label>
	                                <div class="layui-input-block">
	                                	<input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" id="title">
	                                </div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">事件类型</label>
	                           		<div class="layui-input-block">
	                                	<select name="type" id="type">
	                                    	<option value=""></option>
	                                    	<option value="0">代取快递</option>
	                                    	<option value="1">代打印</option>
	                                    	<option value="2">代购餐食</option>
	                                    	<option value="3">代买物品</option>
	                               	 	</select>
	                            	</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">开始时间</label>
	                            	<div class="layui-input-block">
	                                	<input type="text" name="start_time" autocomplete="off"  class="layui-input"> <!-- id="stime"  -->
	                           	 	</div>
								</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">结束时间</label>
	                            	<div class="layui-input-block">
	                                	<input type="text" name="end_time" autocomplete="off"  class="layui-input"> <!-- id="etime" --> 
	                            	</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">费用(¥)</label>
	                            	<div class="layui-input-block">
	                                	<input type="number" name="fee" step="0.01" autocomplete="off" class="layui-input" id="fee">
	                           		</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">收货人</label>
	                            	<div class="layui-input-block">
	                                	<input type="text" name="receiver"  autocomplete="off"  class="layui-input" id="receiver">
	                            	</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">收货电话</label>
	                            	<div class="layui-input-block">
	                                	<input type="text" name="receiver_phone"  autocomplete="off"  class="layui-input" id="receiver_phone">
	                            	</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                            	<label class="layui-form-label">收货地点</label>
	                            	<div class="layui-input-block">
	                                	<input type="text" name="location"  autocomplete="off"  class="layui-input" id="location">
	                            	</div>
	                        	</div>
	                        	<div class="layui-form-item">
	                           		<label class="layui-form-label">具体描述</label>
	                            	<div class="layui-input-block">
	                                	<textarea placeholder="请输入内容" name="descriptions" class="layui-textarea" id="description"></textarea>
	                            	</div>
	                        	</div>
		                        <div class="layui-form-item " >
		                            <div class="layui-input-block">
		                                <button type="submit" class="layui-btn" >立即提交</button>
		                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		                                <button type="reset"  class="layui-btn layui-btn-primary">重置</button>
		                            </div>
		                        </div>
	                        </form>
                    	</div>
                	</div>
            </div>
        </div>
        <div class="layui-col-md4">
		</div>
    </div>
</div>
</body>
</html>