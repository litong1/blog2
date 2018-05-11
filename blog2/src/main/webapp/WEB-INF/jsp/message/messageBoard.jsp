<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

.blogcat{
	color:#01AAED;
	padding-right: 10px;
}
</style>
<link rel="stylesheet" href="layui/css/layui.css">
<title>首页</title>
</head>
<body >
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
			<li class="layui-nav-item"><a href="usercenter/${account.userid }"><img
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
		<div  style="margin: 0 auto;width: 75%;min-height:200px;height: auto;">
			<h1>留言板</h1>
			<textarea id="messageBoard" style="display: none;"></textarea>
			<button class="layui-btn" id="addMessage">发表</button>
		</div>
		
	</div>
 <!--<p ><font color="red">${user.userid}</font></p> -->
<!-- <button class="layui-btn layui-btn-lg layui-btn-warm" id="register" type="button" onclick="userRegister()" >写文章</button> -->
<script src="js/jquery.min.js"></script>
<script src="layui/layui.js"></script>
<script type="text/javascript">
layui.use(['element','layedit'], function(){
	  var element = layui.element;	  
	  var layedit = layui.layedit;
	  layedit.build('messageBoard'); //建立编辑器
	  $('#addMessage').click(function(){
		  
	  });
	});
layui.use('laypage', function(){
	  var laypage = layui.laypage;
	  var url = "articleList";
	  var config = {page:1,pageSize:5};
	  $.getJSON(url,config,function(res){
	   laypage.render({
	      elem: 'paged',
	      count: res.total, //总条数
	      limit:config.pageSize, //每页条数
	      layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
	      theme: '#FFB800', //自定义颜色
	      jump: function(obj, first){
	          if(!first){ //首次则不进入
	           config.page = obj.curr;
	           getArticleListByPage(url,config);
	          }
	      }
	    });
	   parseArticleList(res,config.page);  
	  });
	});
//点击页数从后台获取数据
function getArticleListByPage(url,config){
 $.getJSON(url,config,function(res){
  parseArticleList(res,config.page);
 });
}
//解析数据，currPage参数为预留参数，当删除一行刷新列表时，可以记住当前页而不至于显示到首页去
function parseArticleList(res,currPage){
 var content = "";
 	console.log(res);
	$.each(res.rows,function(v,o){
		console.log(o.article_post_time);
		content+= "<div class='bloglist' >"+
		"<div class='articleinfo' >"+
		"<input type='hidden' class='articleid' value='"+o.articleid+"'>"+
		"<p><a href='article/"+o.articleid+"'><font class='artitle' >"+o.articletitle+"</font></a></p>"+
		"<p class='category'><span class='blogcat' >"+o.article_blogcategory+"</span>"+
			"<a href='usercenter'>"+
				"<img src='"+o.article_useravatar+"'class='layui-nav-img'>"+
					"<span class='arusername' >"+o.article_username+"</span>"+
			"</a>"+

		"</p>"+
	"</div>"+
	"<div class='read' >"+
		"<div>"+
		"</div>"+
		"<p style='color:#01AAED '>1</p>"+
		"<p style='margin-top: 16px;'>阅读量</p>"+
	"</div>"+						
"</div>";
	});
	if(res.total>0){
		$(".arcontent").html(content);
	}else{
		$("#paged").hide();
		$(".arcontent").html("<br/><span style='width:10%;height:30px;display:block;margin:0 auto;'>暂无数据</span>");
	}
	
}

function userRegister(){
	 window.location.href="postedit";
}
</script>
</body>
</html>