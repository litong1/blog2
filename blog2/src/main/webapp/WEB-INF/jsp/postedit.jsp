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
				      <select name="type" lay-verify="required">
				        <option value=""></option>
				        <option value="原创">原创</option>
				        <option value="转载">转载</option>
				        <option value="翻译">翻译</option>
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
				      <select name="bcat" lay-verify="required">
				        <option value=""></option>
				        <option value="人工智能">人工智能</option>
				        <option value="大数据">大数据</option>
				        <option value="机器学习">机器学习</option>
				        <option value="区块链">区块链</option>
				      </select>
			    </div>
  			</div>
  			<div class="layui-form-item">
    			<label class="layui-form-label">私密文章：</label>
    			<div class="layui-input-block">
    			  	<input type="checkbox" name="switch" lay-skin="switch" lay-filter="isPrivate" value="0">
    			</div>
 			 </div>
 			 
 			 <div class="layui-form-item">
    			<div class="layui-input-block">
				      <button class="layui-btn layui-btn-lg layui-bg-red" id="pblog" type="button"  >发布博客</button>
				      <button class="layui-btn layui-btn-lg layui-btn-warm" id="saveDraft" type="button" >保存草稿</button>
				      <button class="layui-btn layui-btn-lg layui-btn-primary" id="register" type="button" >返回</button>
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
<script type="text/javascript" src="js/postedit.js"></script>
</body>
</html>