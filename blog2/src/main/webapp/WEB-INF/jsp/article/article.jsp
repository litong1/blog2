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
<style>
dl{
	display: inline-block;
    width: 21%;
    text-align: center;
}
dt{
	font-size: 14px;
    color: #788087;
}
dd{
	color: #4f4f4f;
    width: 100%;
    overflow: hidden;
}
dd,dl,dt{
	list-style: none;
    margin: 0;
    padding: 0;
}
</style>
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
						src="../${user.useravatar }" class="layui-nav-img">${account.username}</a>
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
		<div style="margin: 0 auto;width: 60%;min-height:200px;height: auto;line-height: 24px;">			
			<!-- 内容主体 -->
			<div class="oparation">
				
			</div>
			<div class="article" style="background-color: #fff;width: 65%;
			min-height:200px;height: auto;margin-top:18px;
			display: inline-block;">
				<div class="header">
					<h1 style="margin: 20px;">${article.articletitle }</h1>
					<div style="float: left;margin-left:20px;margin-bottom: 15px;">
						<div style="display:inline; border: 1px solid #e4ebf4; padding: 2px 6px;
    					font-size: 14px;color: #78909c;margin-right: 20px">
    					${article.articletype }
    					</div>
						<span style="color: #bbb;font-size: 14px;"><fmt:formatDate value="${article.article_post_time}" pattern="yyyy-MM-dd hh:mm:ss" />
						</span>
						<span style="padding-left:20px; color: #4093c6;">${article.article_tag }</span>
					</div>
					<div style="float: right;margin-right: 30px;line-height: 24px;font-size: 14px;color: #888;" >
						<i class="layui-icon">&#xe705;</i>
						<span>666</span>
					</div>
					<hr>
				</div>
				<div class="content" style="margin-bottom: 30px;color: #454545;padding: 20px 30px 0;word-wrap: break-word;">
					${article.articlecontent }
				</div>
				<div class="comment">
				</div>
			</div>
			<div class="person" style="background-color: #fff;width: 30%;
			min-height:200px;height: auto;margin-top:18px;
			display: inline-block;margin-left: 10px;vertical-align: top;">
				<div>
					<div style="width: 100%;height: auto;margin: 20px;">
						<a href="../usercenter/${article.article_userid }">
							<img src="../${article.article_useravatar }" width="64px" height="64px">
							<span style="padding-left: 10px;padding-right: 35px;">${article.article_username}</span>
						</a>
						<button class="layui-btn layui-btn-sm layui-btn-warm">关注</button>
					</div>
				</div>
				<div style="width: 100%;height: 60px;text-align: center;border-bottom: 1px solid #e6e6e6;
							border-top: 1px solid #e6e6e6;padding-bottom: 8px;padding-top: 16px;">
					<dl >
						<dt>原创</dt>
						<dd>1</dd>
					</dl>
					<dl >
						<dt>粉丝</dt>
						<dd>1</dd>
					</dl>
					<dl >
						<dt>喜欢</dt>
						<dd>1</dd>
					</dl>
					<dl >
						<dt>评论</dt>
						<dd>1</dd>
					</dl>
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