<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">文章管理</a>
          
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">评论管理</a>
        </li>
        <li class="layui-nav-item"><a href="categoryList">个人分类管理</a></li>
        <li class="layui-nav-item"><a href="">博客设置</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<form class="layui-form" action="">
    		<div class="layui-form-item">
			    <div class="layui-input-inline">
				      <select name="city" lay-verify="required">
				        <option value=""></option>
				        <option value="0">原创</option>
				        <option value="1">转载</option>
				        <option value="2">翻译</option>
				      </select>
			    </div>
			    <div class="layui-input-inline">
     				 <input type="text" name="articletitle" style="width: 1491px" required  lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
   				</div>
  			</div>
  			<div class="layui-form-item">
  				<textarea  class="ckeditor" name="content"></textarea>
  			</div>
  			<input type="hidden" id="userid" value="${user.userid }">
  			<div class="layui-form-item itemLabel">
  				<label class="layui-form-label">文章标签：</label>
  				
  				<div class="layui-input-block articleLabel">
				      
	  					  <button class="layui-btn layui-btn-sm layui-bg-blue" id="addLabel" type="button">
					   		  <i class="layui-icon">&#xe654;</i> 添加新标签
					      </button>
  					  					  
 					  <p ><font color="#d2d2d2">最多添加5个标签</font></p>
			    </div>
			  
  			</div>
  			<div class="layui-form-item itemCat">
  				<label class="layui-form-label">个人分类：</label>
  				<div class="layui-input-block personCat"> 					  					  
	  					  <button class="layui-btn layui-btn-sm layui-bg-blue" id="addCat" type="button">
					   		  <i class="layui-icon">&#xe654;</i> 添加新分类
					      </button>	
					      			      
			    </div>
  			</div>
  			<div class="layui-form-item">
  				<div class="layui-input-block" id="catlist" >
  				</div>
			</div>
  			<div class="layui-form-item">
  				<label class="layui-form-label">博客分类：</label>
  				<div class="layui-input-inline">
				      <select name="city" lay-verify="required">
				        <option value=""></option>
				        <option value="0">人工智能</option>
				        <option value="1">大数据</option>
				        <option value="2">机器学习</option>
				        <option value="2">区块链</option>
				      </select>
			    </div>
  			</div>
  			<div class="layui-form-item">
    			<label class="layui-form-label">私密文章：</label>
    			<div class="layui-input-block">
    			  	<input type="checkbox" name="switch" lay-skin="switch">
    			</div>
 			 </div>
 			 
 			 <div class="layui-form-item">
    			<div class="layui-input-block">
				      <button class="layui-btn layui-btn-lg layui-bg-red" id="register" type="button" onclick="userRegister()" style="display: inline;">发布博客</button>
				      <button class="layui-btn layui-btn-lg layui-btn-warm" id="register" type="button" onclick="userRegister()">保存草稿</button>
				      <button class="layui-btn layui-btn-lg layui-btn-primary" id="register" type="button" onclick="userRegister()">返回</button>
			    </div>
 			 </div>
    	</form>
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
	//layui.use('layer', function(){
	//	  var layer = layui.layer;
	//	}); 
	
	layui.use('form', function(){
		  var form = layui.form;	
		 
		  form.on('checkbox(cname)', function(data){
			  if(data.elem.checked==true){
				  var input = "<div class='layui-input-inline'><input type='text' name='catlist' class='layui-input' value="+data.value+">"
						 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
						 +"<i class='layui-icon'>&#xe640;</i></button></div>";
						$("#addCat").before(input);
			  }else{
				  $("input[name='catlist']").each(function(key,value){							
						if($("input[name='catlist']")[key].value==data.value){
							console.log($("input[name='catlist']")[key]);
							$("input[name='catlist']")[key].parentNode.remove();
						}
					});
			  }
			  //console.log(data.elem); //得到checkbox原始DOM对象
			  //console.log(data.elem.checked); //是否被选中，true或者false
			  //console.log(data.value); //复选框value值，也可以通过data.elem.value得到
			  //console.log(data.othis); //得到美化后的DOM对象
			});  
		  $("#addCat").click(function(){
				var val = $("#addCat").prev().find("input[name='catlist']").val();
				if(val!=""){
					$("input[name='divclist']").each(function(key,value){
						
						if($("input[name='divclist']")[key].value==val){
							console.log($("input[name='divclist']")[key]);
							$("input[name='divclist']")[key].checked=true;
							form.render();
						}
					});
					var input = "<div class='layui-input-inline'><input type='text' name='catlist' class='layui-input'>"
						 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
						 +"<i class='layui-icon'>&#xe640;</i></button></div>";
						$("#addCat").before(input);
				}else{
					layer.msg('分类名不能为空！0.0');
				}		
			});
		});
	var uid = $("#userid").val();
	$.ajax({
		url:"articleCategoryList",
		method:"get",
		async: true,
		data:{
			_method : "get",
			userid:uid
			},
		dataType : "json",
   		
		success : function(data) {						
				 $.each(data, function(i, item) {
					 var input = "<input type='checkbox' name='divclist' lay-skin='primary' lay-filter='cname' title="+item.categoryname+" value="+item.categoryname+">";
						$("#catlist").append(input);
				 });		
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
		}
	});
	
	$("#postedit").click(function(){
		window.location.href="postedit";
	});
	$(".itemLabel").on('click',"button[name='deleteLabel']",function(){
		 $(this).parent().remove();
		 
	});	
	$("#addLabel").click(function(){
		var val = $("#addLabel").prev().find("input[name='arlabel']").val();
		if(val!=""){
			var input = "<div class='layui-input-inline'><input type='text' name='arlabel' class='layui-input'>"
				 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteLabel' type='button'>"
				 +"<i class='layui-icon'>&#xe640;</i></button></div>";
				 var divNum = $("button[name='deleteLabel']").length;
				 if(divNum <5){
					$("#addLabel").before(input);
				 }else{
					 layer.alert("最多添加五个标签");
				 }
		}else{
			layer.msg('标签名不能为空！0.0');
		}
		
		
	});
	$(".itemCat").on('click',"button[name='deleteCat']",function(){
		 //var cname = $(this).prev().val(); 
		// $.ajax({
		//		url:"category/name/"+cname,
		//		method:"post",
		//		async: false,
		//		data:{
		//			_method : "delete",
		//			categoryname:cname,
		//			userid:uid
		//			},
		//		dataType : "json",
	    //  		
		//		success : function(data) {
		//			$("#addCat").prevAll().html("");			
		//			 $.each(data, function(i, item) {
		//				 var input = "<div class='layui-input-inline'><input type='text' name='title' class='layui-input' value="+item.categoryname+">"
		//				 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
		//				 +"<i class='layui-icon'>&#xe640;</i></button></div>";
		//				$("#addCat").before(input);
		//			 });
		//		},
		//		error : function(XMLHttpRequest, textStatus, errorThrown) {
		//			alert(XMLHttpRequest.status);
	    //           alert(XMLHttpRequest.readyState);
	    //            alert(textStatus);
		//		}
		//	});
		 $(this).parent().remove();
		 
	});	
	
	
	
</script>
</body>
</html>