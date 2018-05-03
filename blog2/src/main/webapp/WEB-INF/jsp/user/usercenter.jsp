<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../layui/css/layui.css">
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
<body >
<div class="layui-layout layui-layout-admin">
  
	<div class="layui-header head">
		<div class="layui-logo" >
		     LTBLOG     </div>
		<ul class="layui-nav layui-layout-left" lay-filter="">
			<li class="layui-nav-item layui-this"><a href="../index">博客</a></li>
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
						src="../${user.useravatar }" class="layui-nav-img">${account.username }</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">修改信息</a>
						</dd>
						<dd>
							<a href="javascript:;">安全管理</a>
						</dd>
						<dd>
							<a href="login">退了</a>
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
								<img src="../${user.useravatar }" width="150px" height="150px">
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
								<span id="susername">${user.username }</span>
								
							</dt>
							<dd class="user-detail">
								<input type="hidden" id="userindustry" value="${user.userindustry }">
								<span id="suserindustry">${user.userindustry==null?"未填写行业":user.userindustry }</span>
								<span>|</span>
								<input type="hidden" id="userposition" value="${user.userposition }">
								<span id="suserposition">${user.userposition==null?"未填写职位":user.userposition }</span>
								<span>|</span>
								<input type="hidden" id="user_real_name" value="${user.user_real_name }">
								<span id="suser_real_name">${user.user_real_name==null?"未填写姓名":user.user_real_name }</span>
								<span>|</span>
								<input type="hidden" id="user_address" value="${user.user_address }">
								<span id="suser_address">${user.user_address==null?"未填写地址":user.user_address }</span>
								<span>|</span>
								<input type="hidden" id="user_sex" value="${user.user_sex }">
								<span id="suser_sex">${user.user_sex==null?"未填写性别":(user.user_sex==0?"男":"女") }</span>
								<span>|</span>
								<input type="hidden" id="userbirthday" value="${user.userbirthday }">
								<span id="suserbirthday" >
									<c:choose>

										<c:when test="${user.userbirthday==null}">
											<!--如果 -->
											未填写生日
										</c:when>

										<c:otherwise>
											<!--否则 -->
 											<fmt:formatDate value="${user.userbirthday}" pattern="yyyy-MM-dd"/>
										</c:otherwise>

									</c:choose>
									
								</span>
								<span>|</span>
								<input type="hidden" id="user_mail_address" value="${user.user_mail_address }">
								<span id="suser_mail_address">${user.user_mail_address==null?"未填写邮箱":user.user_mail_address }</span>
								<input type="hidden" id="userintro" value="${user.userintro }">
								<input type="hidden" id="userid" value="${user.userid }">
							</dd>
							
							<dd class="user-sign">							
								<span id="suserintro">${user.userintro==null?"个人简介":user.userintro }</span>
							</dd>
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
					<div class="layui-tab-item layui-show">
						<c:forEach var="ar" items="${arList}" varStatus="i">
							<p>${ar.articletitle }</p>
						</c:forEach>
					</div>
					<div class="layui-tab-item">
						<c:forEach var="co" items="${coList}" varStatus="i">
							<p>${co.articletitle }</p>
						</c:forEach>
					</div>
					<div class="layui-tab-item">
					</div>
					<div class="layui-tab-item">
						我关注的
						<c:forEach var="follow" items="${followList}" varStatus="i">
								<p>${follow.username }</p>
						</c:forEach>
						我的粉丝
						<c:forEach var="fans" items="${fansList}" varStatus="i">
								<p>${fans.username }</p>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
	</div>
 <!--<p ><font color="red">${user.userid}</font></p> -->
<!-- <button class="layui-btn layui-btn-lg layui-btn-warm" id="register" type="button" onclick="userRegister()" >写文章</button> -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../layui/layui.js"></script>
<script type="text/javascript">
function getBirthday(birthday) {
	var d = new Date(birthday);
	var sd = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
	return sd;
}
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
	 var form = layui.form;	
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
					  $("#editDiv").css("display","block");
					  $("input[name='username']").val($("#susername").text());
					  $("input[name='user_mail_address']").val($("#suser_mail_address").text());
					  $("input[name='user_real_name']").val($("#suser_real_name").text());
					  console.log($("#suser_sex").text());
					  if($("#suser_sex").text()=="男"){
						  $("input[name='user_sex']")[0].checked=true;
						  form.render();
					  }else{
						  $("input[name='user_sex']")[1].checked=true;
						  form.render();
					  }
					  $("input[name='user_address']").val($("#suser_address").text());
					  $("input[name='userindustry']").val($("#suserindustry").text());
					  $("#birthday").val($("#suserbirthday").text().replace(/[\r\n]/g,"").replace(/(^\s*)|(\s*$)/g, ""));
					  console.log($("#suserbirthday").text().replace(/[\r\n]/g,"").replace(/(^\s*)|(\s*$)/g, ""));
					  $("input[name='userposition']").val($("#suserposition").text());
					  $("textarea[name='userintro']").val($("#suserintro").text());
				  },
				  yes: function(index, layero){ 
					  	var vuserid = $("#userid").val();
					  	var vusername = $("input[name='username']").val();
						var vuser_mail_address = $("input[name='user_mail_address']").val();
						var vuser_real_name = $("input[name='user_real_name']").val();
						var vuser_sex = null;
						$("input[name='user_sex']").each(function(key,value){
							
							if($("input[name='user_sex']")[key].checked==true){
								console.log($("input[name='user_sex']")[key]);
								if($("input[name='user_sex']")[key].title=="男"){
									vuser_sex = 0;
								}else{
									vuser_sex = 1;
								}
								
								form.render();
							}
						});
						console.log("sex: " + vuser_sex);
						var vuser_address = $("input[name='user_address']").val();
						var vuserindustry = $("input[name='userindustry']").val();
						var vuserbirthday = $("#birthday").val();
						
						var vuserposition = $("input[name='userposition']").val();
						var vuserintro = $("textarea[name='userintro']").val();
					  $.ajax({
							url:"editUser",
							method:"post",
							async: true,
							data:{
								_method : "put",
								userid : vuserid,
								username : vusername,
								user_mail_address : vuser_mail_address,
								user_real_name : vuser_real_name,
								user_sex : vuser_sex,
								user_address : vuser_address,
								userindustry : vuserindustry,
								userposition : vuserposition,
								userbirthday : new Date(vuserbirthday.replace(/-/g,"/")),
								userintro : vuserintro
								},
							dataType : "json",
				       		
							success : function(data) {
								
								$("#susername").html(vusername);	
								$("#suserindustry").html(vuserindustry);
								$("#suserposition").html(vuserposition);
								$("#suser_real_name").html(vuser_real_name);
								$("#suser_address").html(vuser_address);
								if(vuser_sex==0){
									$("#suser_sex").html("男");
								}else{
									$("#suser_sex").html("女");
								}
								
								$("#suserbirthday").html(vuserbirthday);
								$("#suser_mail_address").html(vuser_mail_address);							
								$("#suserintro").html(vuserintro);
							},
							error : function(XMLHttpRequest, textStatus, errorThrown) {
								alert(XMLHttpRequest.status);
				                alert(XMLHttpRequest.readyState);
				                alert(textStatus);
							}
						}); 
					  $("#editDiv").css("display","none");
				    layer.close(index); //如果设定了yes回调，需进行手工关闭
				  },
				  btn2: function(index, layero){
					    //按钮【按钮二】的回调
					    $("#editDiv").css("display","none");
					    layer.close(index);					
					    //return false 开启该代码可禁止点击该按钮关闭
					  },
				  cancel: function(index, layero){ 
					  if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
						  	$("#editDiv").css("display","none");
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
<div id="editDiv" style="display: none;">
	<form class="layui-form" action="" id="edituserform">
		<div class="layui-form-item">
			<label class="layui-form-label">昵称：</label>
			<div class="layui-input-block">
				<input type="text" name="username" 
					placeholder="请输入昵称" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">实名：</label>
			<div class="layui-input-block">
				<input type="text" name="user_real_name" 
					placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职位：</label>
			<div class="layui-input-block">
				<input type="text" name="userposition" 
					placeholder="请输入职位" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-block">
				<input type="radio" name="user_sex" value="0" title="男"> <input
					type="radio" name="user_sex" value="1" title="女" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">生日：</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input" id="birthday" pattern="yyyy-MM-dd"> 
			</div>
			<label class="layui-form-label">行业：</label>
			<div class="layui-input-block">
				<input type="text" name="userindustry" 
					placeholder="请输入行业" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地区：</label>
			<div class="layui-input-block">
				<input type="text" name="user_address" 
					placeholder="请输入地区" autocomplete="off" class="layui-input">
			</div>	
			<label class="layui-form-label">邮箱：</label>
			<div class="layui-input-block">
				<input type="text" name="user_mail_address" 
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