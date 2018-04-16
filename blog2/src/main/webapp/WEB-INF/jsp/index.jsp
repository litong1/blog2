<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.articletitle{
	
	
	
}
.bloglist{
	
}

</style>
<link rel="stylesheet" href="layui/css/layui.css">
<title>首页</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  
	<div class="layui-header head">
		<div class="layui-logo" >
		     LTBLOG     </div>
		<ul class="layui-nav layui-layout-left" lay-filter="">
			<li class="layui-nav-item layui-this"><a href="">博客</a></li>
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
			<li class="layui-nav-item"><a href="usercenter/${article.article_userid }"><img
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
		<div class="layui-body" style="margin: 0 auto">
			<div>
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">推荐</a>
						
					<li class="layui-nav-item"><a href="javascript:;">最新</a>
					</li>
					<li class="layui-nav-item"><a href="">技术</a></li>
					<li class="layui-nav-item"><a href="">文青</a></li>
				</ul>
			</div>
			<!-- 内容主体 -->
			<div class="layui-body" >
				<div class="main" style="margin: 0 auto;">
					<div class="bodyleft" style="width: 50%; float: left;margin-left: 50px;">
						<c:forEach items="${alist}" var="a" varStatus="st">
							<div class="bloglist" style="width:100%;height:100px;
							border: 1px solid #2F4056;margin-bottom: 5px;vertical-align:middle;">
								<div class="articleinfo" style="float: left;padding: 13px;">
									<input type="hidden" class="articleid" value="${a.articleid }">
									<p><a href="article/${a.articleid}" ><font style="font-size:20px; font-weight: bold;">${a.articletitle}</font></a></p>
									<p style="margin-top: 15px;"><span style="color:#01AAED;padding-right: 10px;">${a.article_blogcategory }</span>
										<a href="usercenter">
											<img src="${a.article_useravatar }"
												class="layui-nav-img">
												<span style="margin-right: 10px;padding-left: 5px;">${a.article_username}</span>
										</a>
										<fmt:formatDate value="${a.article_post_time}"
											pattern="yyyy-MM-dd hh:mm:ss" />
									</p>
								</div>
								<div style="float: right;margin-top: 7px;padding: 10px;">
									<div>
									</div>
									<p style="color:#01AAED ">1</p>
									<p style="margin-top: 16px;">阅读量</p>
								</div>
								
							</div>
						</c:forEach>
						<div>
						</div>
					</div>
					
					<div class="bodyright" style="width: 10%; float: right;">
						<div>今日推荐</div>
						<div style="width: 100%; height: 300px; background-color: orange;">

						</div>
					</div>
				</div>

			</div>
			
				
			
		</div>
		
	</div>
 <!--<p ><font color="red">${user.userid}</font></p> -->
<!-- <button class="layui-btn layui-btn-lg layui-btn-warm" id="register" type="button" onclick="userRegister()" >写文章</button> -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="layui/layui.js"></script>
<script type="text/javascript">
layui.use('element', function(){
	  var element = layui.element;	  
	});
layui.use('laypage', function(){
	  var laypage = layui.laypage;
	  
	  //执行一个laypage实例
	  laypage.render({
	    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    ,count: 50 //数据总数，从服务端得到
	    ,jump: function(obj, first){
	        //obj包含了当前分页的所有参数，比如：
	        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
	        var curr = obj.curr;
	        console.log(obj.limit); //得到每页显示的条数
	        var limit = obj.limit;
	        
	        //首次不执行
	        if(!first){
	          //do something
	        }
	      }
	  });
	});

function userRegister(){
	 window.location.href="postedit";
}
</script>
</body>
</html>