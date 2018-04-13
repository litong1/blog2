<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ar.articletitle }-灵通博客</title>
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
			<li class="layui-nav-item"><a href="usercenter"><img
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
			<!-- 内容主体 -->
			<div class="oparation">
			</div>
			<div class="article">
				<div class="header">
				</div>
				<div class="content">
				</div>
				<div class="comment">
				</div>
			</div>
			<div class="person">
				<div>
					<div>
						${article.useravatar }
					</div>
					<div>
						${article.username }
						<button>关注</button>
					</div>
				</div>
				<div>
					<div>
						<p>原创</p>
						<p></p>
					</div>
					<div>
						<p>粉丝</p>
						<p></p>
					</div>
					<div>
						<p>喜欢</p>
						<p></p>
					</div>
					<div>
						<p>评论</p>
						<p></p>
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
<script src="layui/layui.js"></script>
<script type="text/javascript">
layui.use('element', function(){
	  var element = layui.element;
	  
	  //…
	});

</script>
</body>
</html>