<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css">
<title>${ar.articletitle }-灵通博客</title>
</head>
<body class="layui-layout-body" style="background-color: #f5f6f7;">
<div class="layui-layout layui-layout-admin">
  
	<div class="layui-header head">
		<div class="layui-logo" >
		     LTBLOG     </div>
		<ul class="layui-nav layui-layout-left" lay-filter="">
			<li class="layui-nav-item layui-this"><a href="index">博客</a></li>
			<li class="layui-nav-item "><a href="">下载</a></li>
			<li class="layui-nav-item"><a href="">动态</a></li>
			<li class="layui-nav-item"><a href="javascript:;">留言板</a>
			<li class="layui-nav-item"><a href="">社区</a></li>
		</ul>
		<div>
		</div>
		
		<ul class="layui-nav layui-layout-right">
			<input type="text">
			<li class="layui-nav-item "><a href="postedit">写博客</a></li>
			<li class="layui-nav-item "><a href="">发动态</a></li>
			<li class="layui-nav-item"><a href="../usercenter/${account.userid }"><img
						src="${user.useravatar }" class="layui-nav-img">${account.username}</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">修改信息</a>
						</dd>
						<dd>
							<a href="javascript:;">安全管理</a>
						</dd>
						<dd>
							<a href="javascript:;">退出</a>
						</dd>
					</dl>
			</li>
		</ul>
	</div>
		<div style="margin: 0 auto;width: 60%;min-height:200px;height: auto;">			
			<!-- 内容主体 -->
			<div class="oparation">
				
			</div>
			<div class="article" style="background-color: #fff;width: 65%;
			min-height:200px;height: auto;margin-top:18px;
			display: inline-block;">
				<div class="header">
					<h1>${article.articletitle }</h1>
					<div style="float: left">
						<span style="border: 1px solid #f2f2f2;">${article.articletype }</span>
						<span><fmt:formatDate value="${article.article_post_time}" pattern="yyyy-MM-dd hh:mm:ss" />
						</span>
						<span>${article.article_tag }</span>
					</div>
					<div style="float: right">
						<span>666</span>
					</div>
					<hr>
				</div>
				<div class="content">
					${article.articlecontent }
				</div>
				<div class="comment">
				</div>
			</div>
			<div class="person" style="background-color: #fff;width: 30%;
			min-height:200px;height: auto;margin-top:18px;
			display: inline-block;margin-left: 10px;vertical-align: top;">
				<div>
					<div>
						<a href="../usercenter/${article.article_userid }"><img
						src="${article.article_useravatar }" class="layui-nav-img">${article.article_username}</a>
						<button>关注</button>
					</div>
				</div>
				<div style="width: 100%;height: 60px;">
					<div style="display: inline-block;">
						<p>原创</p>
						<p>1</p>
					</div>
					<div style="display: inline-block;">
						<p>粉丝</p>
						<p>1</p>
					</div>
					<div style="display: inline-block;">
						<p>喜欢</p>
						<p>1</p>
					</div>
					<div style="display: inline-block;">
						<p>评论</p>
						<p>1</p>
					</div>
				</div>
				<div class="new">
				</div>
				<div class="分类">
					
				</div>
				<div class="热门">
				</div>
			</div>	
			
		</div>
		
	</div>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../layui/layui.js"></script>
<script type="text/javascript">
layui.use('element', function(){
	  var element = layui.element;
	  
	  //…
	});
$(".usercenter").click(function(){
	var userid = $(this).prev().val();
	
});
</script>
</body>
</html>