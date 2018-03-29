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

		<div id="addCatDiv">
			<input type="hidden" id="userid" value="${user.userid }">
			<input type="text" id="catname" required lay-verify="required"
						placeholder="请输入分类名称" autocomplete="off" class="layui-input"
						style="width: 257px">
			<button class="layui-btn layui-btn-lg layui-btn-normal" id="addCatname"
					type="button">添加分类</button>
		</div>
	<table class="layui-table" align='center' border='1' cellspacing='0'>
        <tr id="catlist">
            <td>类别</td>
            <td>操作</td>
            <td>前台是否展示</td>
            <td>文章数</td>
        </tr>
        <c:forEach  items="${clist}" var="c" varStatus="st">
            <tr >
                <td>${c.categoryname}</td>           
                <td>
               		 <a class="editname">编辑</a>
               		 <input type="hidden" class="hidcatid" value="${c.categoryid}">
               		 <input type="hidden" class="hidcatname" value="${c.categoryname}">
               		 <input type="hidden" class="hidcatfront" value="${c.isShowed_atFront}">
               		 <input type="hidden" class="hiduserid" value="${c.userid}">
               		 <a class="deletename">删除</a>
               		 
				</td>
				<td>${c.isShowed_atFront}<input type="checkbox" name="switch" lay-skin="switch"></td>
                <td>${c.articlenum}</td>
            </tr>
        </c:forEach>
    </table>
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
		 form.on('switch(pagefront)', function(data){
			 if(data.elem.checked==true){
				 data.elem.value=1;
				 console.log(data.elem.value);
			 }else{
				 data.elem.value=0;
				 console.log(data.elem.value);
			 }
		 });
		layui.use('layer', function(){
			  var layer = layui.layer;
			  var val = $("#switch").val();
			  if(val==1){
				  $("#switch").checked=true;
			  }else{
				  $("#switch").checked=false;
			  }
			  $(".layui-table").on('click',".editname",function(){
					var cid = $(this).parent().children(".hidcatid").val();
					var uid = $(this).parent().children(".hiduserid").val();
					var cname = $(this).parent().children(".hidcatname").val();
					var cfront = $(this).parent().children(".hidcatfront").val();
					layer.open({
						  type: 1,
						  title: '编辑分类',
						  content: $("#editform"),
						  btn:['确认编辑'],
						  success: function(layero, index){
							$("#pagename").val(cname);
							if(cfront==0){
								$("#pagefront").checked=false;
								$("#pagefront").val(cfront);
							}else{
								//alert("11");
								$("#pagefront").attr("checked",true);
								form.render();
								$("#pagefront").val(cfront);
							}
						  },
						  yes: function(index, layero){ 
							  var nowname = $("#pagename").val();
							  var nowfront = $("#pagefront").val();
							  $.ajax({
									url:"editCategory",
									method:"post",
									async: true,
									data:{
										_method : "put",
										categoryname : nowname,
										categoryid : cid,
										userid : uid,
										isShowed_atFront : nowfront
										},
									dataType : "json",
						       		
									success : function(data) {
										
											$("#catlist").nextAll().html("");			
											 $.each(data, function(i, item) {
												 var content = "<tr>"+
												 				"<td>"+item.categoryname+"</td>"+
												 				"<td><a class='editname'>编辑</a>"+
												 				" <input type='hidden' class='hidcatid' value="+item.categoryid+">"+
												 				" <input type='hidden' class='hiduserid' value="+item.userid+">"+
												 				"<a class='deletename'>删除</a></td>"+
												 				"<td>"+item.isShowed_atFront+"<input type='checkbox' name='switch' lay-skin='switch'>"+
												 				"<td>"+item.articlenum+"</td></tr>";
												 $("#catlist").after(content);
											 });										
										
									},
									error : function(XMLHttpRequest, textStatus, errorThrown) {
										alert(XMLHttpRequest.status);
						                alert(XMLHttpRequest.readyState);
						                alert(textStatus);
									}
								});
						    layer.close(index); //如果设定了yes回调，需进行手工关闭
						  }
						}); 
				});
			}); 
	});
	
	
	$("#postedit").click(function(){
		window.location.href="postedit";
	});
	$("#addCatname").click(function(){
		var name = $("#catname").val();
		var uid = $("#userid").val();
		$.ajax({
			url:"category",
			method:"post",
			async: true,
			data:{
				_method : "put",
				categoryname:name,
				userid:uid
				},
			dataType : "json",
       		
			success : function(data) {
				if(data[0].categoryname==""){
					layer.tips('分类名已存在0.0', '#addCatname');
				}else{
					$("#catlist").nextAll().html("");			
					 $.each(data, function(i, item) {
						 var content = "<tr>"+
						 				"<td>"+item.categoryname+"</td>"+
						 				"<td><a class='editname'>编辑</a>"+
						 				" <input type='hidden' class='hidcatid' value="+item.categoryid+">"+
						 				" <input type='hidden' class='hiduserid' value="+item.userid+">"+
						 				"<a class='deletename'>删除</a></td>"+
						 				"<td>"+item.isShowed_atFront+"<input type='checkbox' name='switch' lay-skin='switch'>"+
						 				"<td>"+item.articlenum+"</td></tr>";
						 $("#catlist").after(content);
					 });
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
			}
		});
	});
	$(".layui-table").on('click',".deletename",function(){
		var cid = $(this).parent().children(".hidcatid").val();
		var uid = $(this).parent().children(".hiduserid").val();
		$.ajax({
			url:"category/"+cid,
			method:"post",
			async: false,
			data:{
				_method : "delete",
				categoryid:cid,
				userid:uid
				},
			dataType : "json",
       		
			success : function(data) {
				$("#catlist").nextAll().html("");			
				 $.each(data, function(i, item) {
					 var content = "<tr>"+
					 				"<td>"+item.categoryname+"</td>"+
					 				"<td><a class='editname'>编辑</a>"+
					 				" <input type='hidden' class='hidcatid' value="+item.categoryid+">"+
					 				" <input type='hidden' class='hiduserid' value="+item.userid+">"+
					 				"<a class='deletename'>删除</a></td>"+
					 				"<td>"+item.isShowed_atFront+"<input type='checkbox' name='switch' lay-skin='switch'>"+
					 				"<td>"+item.articlenum+"</td></tr>";
					 $("#catlist").after(content);
				 });
			},
			error : function(data) {
				alert(data);
				//window.location.href = "categoryList";
			}
		});
	});
</script>
</body>
<div>
	<form class="layui-form" method="post" action="editCategory" id="editform">
	 	<input type="hidden" name="_method" value="PUT">
		<div class="layui-form-item">
			<label class="layui-form-label">分类名称</label>
			<div class="layui-input-inline">
				<input ype="text" name="username" required lay-verify="required"
					id="pagename" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">前台展示</label>
			<div class="layui-input-inline">
				<input type="checkbox" name="isShowed_atFront" lay-skin="switch"
					id="pagefront" value="" lay-filter="pagefront">
			</div>
		</div>
	</form>
</div>
</html>