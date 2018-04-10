<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="layui/css/layui.css">
<title>我的博客</title>
<style>
.user-photo{
	width: 150px;
    height: 200px;
    float: left;
    margin: 15px 30px 15px 20px;
}
.user-info{
    float: left;
    width: 950px;
    margin-top: 30px;
}
dt{
display: block;
}
.user-detail{
	overfolw: hidden;
    font-size: 16px;
    color: #333;
    margin-top: 10px;
}
.user-info .user-nick-name span {
    display: block;  
    font-size: 24px;
    color: #333;
    font-weight: normal;
}
.user-info .user-detail span {
	font-size: 14px;
    color: #999;
    padding: 0 14px;
}
.user-photo .follow_num {
    width: 72px;
    height: 32px;
    border-right: 1px solid #f0f0f0;
    float: left;
    font-size: 14px;
    color: #999;
    text-align: center;
    overflow: hidden;
}
.user-photo .follow_num b{
    color: #333;
    display: block;
    width: 72px;
    text-align: center;
    line-height: 14px;
    float: left;
}
.user-photo .fans_num {
    width: 72px;
    height: 32px;
    float: left;
    font-size: 14px;
    color: #999;
    text-align: center;
    overflow: hidden;
}
.user-photo .fans_num b{
    color: #333;
    display: block;
    width: 72px;
    text-align: center;
    line-height: 14px;
    float: left;
}
.user-info .user-sign {
    overflow: hidden;
    font-size: 14px;
    color: #999;
    border-top: 1px solid #FFB800;
    padding-top: 8px;
    margin-top: 10px;
    line-height: 22px;
    word-wrap: break-word;
    word-break: break-all;
}
body{
background-color:#f2f2f2; 
}
</style>
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
			<li class="layui-nav-item "><a href="">写博客</a></li>
			<li class="layui-nav-item "><a href="">发动态</a></li>
			<li class="layui-nav-item"><a href=""><img
						src="http://t.cn/RCzsdCq" class="layui-nav-img">${user.username }</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">修改信息</a>
						</dd>
						<dd>
							<a href="javascript:;">安全管理</a>
						</dd>
						<dd>
							<a href="javascript:;">退了</a>
						</dd>
					</dl>
			</li>
		</ul>
	</div>
		<div  style="width:65%;height: auto;margin: 0 auto;">
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" >
				<ul class="layui-tab-title" style="margin: 0 auto">
					<li class="layui-this">个人中心</li>
					<li>我的消息</li>
					<li>我的博客</li>
					<li>我的下载</li>
					<li>账号</li>
				</ul>
				<div class="layui-tab-content" style="width: 100%;min-height:200px;height:auto; margin:0 auto;background-color: #fff;">
					
					<div class="user_info_con" style="background-color: #fff;">
						
						<dl class="user-photo">
							<dt>
								<img src="http://t.cn/RCzsdCq" width="150px" height="150px">
							</dt>

							<dd class="follow_num">
								<b><a href="/user/follow" target="_blank">6</a></b> 关注
							</dd>
							<dd class="fans_num">
								<b><a href="/user/follow" target="_blank">6</a></b> 粉丝
							</dd>
						</dl>
						<dl class="user-info">
							<dt class="user-nick-name">
								<span>${user.username }</span>
								
							</dt>
							<dd class="user-detail">
								<span>未填写行业</span>
								<span>|</span>
								<span>未填写职位</span>
								<span>|</span>
								<span>未填写姓名</span>
								<span>|</span>
								<span>未填写地址</span>
								<span>|</span>
								<span>未填写性别</span>
								<span>|</span>
								<span>未填写生日</span>
								<span>|</span>
								<span>未填写邮箱</span>
							</dd>
							
							<dd class="user-sign">个人简介</dd>
							<dd>
								<button class="layui-btn layui-btn-lg layui-btn-primary" id="edituser"
									style="display: inline; float: right;">
									<i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">
										&#xe642; </i>修改个人资料
								</button>
							</dd>
						</dl>
					</div>
					
				</div>
				
			</div>
			<div class="layui-tab layui-tab-card"
				style="width: 101.5%; height: 600px; margin: 0 auto;">
				<ul class="layui-tab-title">
					<li class="layui-this">我的博客</li>
					<li>我的收藏</li>
					<li>我的资料</li>
					<li>我的关系</li>
				</ul>
				<div class="layui-tab-content" style="height: 100px;">
					<div class="layui-tab-item layui-show">1</div>
					<div class="layui-tab-item">2</div>
					<div class="layui-tab-item">3</div>
					<div class="layui-tab-item">4</div>
					<div class="layui-tab-item">5</div>
					<div class="layui-tab-item">6</div>
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
	  
	  //…
	});
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#birthday' //指定元素
	  });
});
layui.use('form', function(){
	layui.use('layer', function(){
		
		$("#edituser").click(function(){
			 var layer = layui.layer;
			 layer.open({
				  type: 1,
				  title: '编辑分类',
				  area: ['490px', '520px'],
				  content: $("#edituserform"),
				  btn:['保存','取消'],
				  success: function(layero, index){
					
				  },
				  yes: function(index, layero){ 
					  $.ajax({
							url:"editUser",
							method:"post",
							async: true,
							data:{
								_method : "put",
								user_mail_address : nowname,
								user_real_name : cid,
								user_sex : uid,
								user_address : nowfront,
								userindustry : aa,
								userposition : bb,
								userintro : cc
								},
							dataType : "json",
				       		
							success : function(data) {
								
									$(".user-detail").html("");			
									 $.each(data, function(i, item) {
										 var content = "<span>"+
										 			未填写行业+
										 			"</span><span>|</span><span>"+
										 			未填写职位+
										 			"</span><span>|</span><span>"+
										 			未填写姓名+
										 			"</span><span>|</span><span>"+
										 			未填写地址+
										 			"</span><span>|</span><span>"+
										 			未填写性别+
										 			"</span><span>|</span><span>"+
										 			未填写生日+
										 			"</span><span>|</span><span>"+
										 			未填写邮箱+"</span>";
										 $(".user-detail").append(content);
									 });										
								
							},
							error : function(XMLHttpRequest, textStatus, errorThrown) {
								alert(XMLHttpRequest.status);
				                alert(XMLHttpRequest.readyState);
				                alert(textStatus);
							}
						}); 
				    layer.close(index); //如果设定了yes回调，需进行手工关闭
				  },
				  btn2: function(index, layero){
					    //按钮【按钮二】的回调
					    layer.close(index);
					    console.log("aaa");
					    //return false 开启该代码可禁止点击该按钮关闭
					  },
				  cancel: function(index, layero){ 
					  if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
						    layer.close(index)
						  }
						  return false;
					  }
				}); 
		});
	});
});


function userRegister(){
	 window.location.href="postedit";
	}
</script>
</body>
<div >
	<form class="layui-form" action="" id="edituserform">
		<div class="layui-form-item">
			<label class="layui-form-label">昵称：</label>
			<div class="layui-input-block">
				<input type="text" name="username" required lay-verify="required"
					placeholder="请输入昵称" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">实名：</label>
			<div class="layui-input-block">
				<input type="text" name="user_real_name" required lay-verify="required"
					placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职位：</label>
			<div class="layui-input-block">
				<input type="text" name="userposition" required lay-verify="required"
					placeholder="请输入职位" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-block">
				<input type="radio" name="user_sex" value="男" title="男"> <input
					type="radio" name="sex" value="女" title="女" checked>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">生日：</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" id="birthday"> 
			</div>
			<label class="layui-form-label">行业：</label>
			<div class="layui-input-block">
				<input type="text" name="userindustry" required lay-verify="required"
					placeholder="请输入行业" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地区：</label>
			<div class="layui-input-block">
				<input type="text" name="user_address" required lay-verify="required"
					placeholder="请输入地区" autocomplete="off" class="layui-input">
			</div>	
			<label class="layui-form-label">邮箱：</label>
			<div class="layui-input-block">
				<input type="text" name="user_mail_address" required lay-verify="required"
					placeholder="请输入邮箱" autocomplete="off" class="layui-input">
			</div>	
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">简介</label>
			<div class="layui-input-block">
				<textarea name="userintro" placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>

	</form>
</div>
</html>