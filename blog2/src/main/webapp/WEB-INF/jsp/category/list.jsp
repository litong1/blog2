<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">

</style>
<title>Insert title here</title>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<div class="layui-header head">
    <div class="layui-logo">灵通博客写作台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
          <dd><a href="">留言板管理</a></dd>
        </dl>
      </li>
    </ul>
    
    <ul class="layui-nav layui-layout-right">
    	<li class="layui-nav-item">
    		 <button class="layui-btn layui-btn-lg layui-btn-warm" id="postedit" type="button">写文章</button>
    	</li>
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ${user.username }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退出</a></li>
     
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item">
          <a class="" href="javascript:;">文章管理</a>
          
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">评论管理</a>
        </li>
        <li class="layui-nav-item  layui-nav-itemed"><a href="categoryList">个人分类管理</a></li>
        <li class="layui-nav-item"><a href="">博客设置</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<div class="layui-elem-quote" st>
  			<p>个人分类管理</p>
		</div>
	
    <table class="layui-table" align='center' border='1' cellspacing='0'>
        <tr>
            <td>类别</td>
            <td>操作</td>
            <td>前台是否展示</td>
            <td>文章数</td>
        </tr>
        <c:forEach items="${clist}" var="c" varStatus="st">
            <tr>
                <td>${c.categoryname}</td>           
                <td>
               		 <a href="category/${c.userid}">编辑</a>
               		 <a class="delete" href="category/${c.userid}">删除</a>
				</td>
				<td>${c.isShowed_atFront}<input type="checkbox" name="switch" lay-skin="switch"></td>
                <td>${c.articlenum}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="checkbox" name="switch" lay-skin="switch">
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    博客毕业设计@litong    0.0
  </div>
</div>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script src="layui/layui.js"></script>

<script>
//JavaScript代码区域
	layui.use('element', function(){
	  var element = layui.element;
	  
	});
	layui.use('form', function(){
		  var form = layui.form;	  	 
		});
	$("#postedit").click(function(){
		window.location.href="postedit";
	});
	$(".itemLabel").on('click',"button[name='deleteLabel']",function(){
		 $(this).parent().remove();
		 
	});	
	$("#addLabel").click(function(){
		var input = "<div class='layui-input-inline'><input type='text' name='title' class='layui-input'>"
		 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteLabel' type='button'>"
		 +"<i class='layui-icon'>&#xe640;</i></button></div>";
		 var divNum = $("button[name='deleteLabel']").length;
		 if(divNum <5){
			$(".articleLabel:last").before(input);
		 }else{
			 alert("最多添加五个标签");
		 }
	});
	$(".itemCat").on('click',"button[name='deleteCat']",function(){
		 $(this).parent().remove();
		 
	})	
	$("#addCat").click(function(){
		var input = "<div class='layui-input-inline'><input type='text' name='title' class='layui-input'>"
		 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
		 +"<i class='layui-icon'>&#xe640;</i></button></div>";
		$("#addCat").before(input);
	});
	
	
</script>
</body>
</html>
















	
	
</body>
</html>