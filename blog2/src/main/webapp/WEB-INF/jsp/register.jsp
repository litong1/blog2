<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<title>博客-登录界面</title>
<link>
<style>
body{
	background-color: #F0F0F0;
}
#main{
	width: 500px;
    height: 500px;
	margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
.inp {
	border: 1px solid #cccccc;
	border-radius: 2px;
	padding: 0 10px;
	width: 278px;
	height: 40px;
	font-size: 18px;
}

.btn {
	border: 1px solid #cccccc;
	border-radius: 2px;
	width: 100px;
	height: 40px;
	font-size: 16px;
	color: #666;
	cursor: pointer;
	background: white linear-gradient(180deg, #ffffff 0%, #f3f3f3 100%);
}

.btn:hover {
	background: white linear-gradient(0deg, #ffffff 0%, #f3f3f3 100%)
}

#captcha1 {
	width: 200px;
	display: inline-block;
}

.shows {
	display: block;
}

.hides {
	display: none;
}

#notice1 {
	color: red;
}

#wait1 {
	text-align: left;
	color: #666;
	margin: 0;
}
</style>
</head>
<body>
	<div class="layui-row" style="text-align: center;margin: 15px;">
 		 <p><b style="font-size: 20px;">灵通博客 </b> <span style="font-size: 15px;margin-left: 15px;">欢迎注册</span></p>
	</div>
	<hr class="layui-bg-orange">
	<div class="layui-container" id ="main">
		<div class="layui-fluid">
			<form class="layui-form" method="post" action="register">
				<input type="hidden" name="_method" value="PUT">
				<div class="layui-form-item">
					<label class="layui-form-label">用户昵称：</label>
					<div class="layui-input-block">
						 <input type="text" name="username"  
						 lay-verify="username" placeholder="请输入昵称" autocomplete="off" 
						 class="layui-input" style="width:257px"> 
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户密码：</label>
					<div class="layui-input-inline">
						<input type="password" name="userpasswd" 
						required lay-verify="userpasswd" placeholder="请输入密码" autocomplete="off" 
						class="layui-input" style="width:257px"> 
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">完成验证：</label>
					<div class="layui-input-inline" id="captcha1">
						<p id="wait1" class="shows">正在加载验证码......</p>
					</div>
					<br><br><br>
					<div class="layui-input-block" style= "">
						<p id="notice1" class="hides" >请先完成验证</p>
					</div>
				</div>											
				<div class="layui-form-item">
					<div class="layui-input-block">
					<button class="layui-btn layui-btn-lg layui-btn-normal" id="submit1" lay-submit>注册</button>
					<button class="layui-btn layui-btn-lg layui-btn-warm" 
					id="login" type="button" onclick="userLogin()">立即登录</button>(已有账户？)
					</div>
				</div>

			</form>
		</div>
	</div>

	<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
	<!-- 可选: 包含 jQuery 库 -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
	<script src="layui/layui.js"></script>
	<script src="js/gt.js"></script>
	<script>
		//一般直接写在一个js文件中
		layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, form = layui.form;			
			form.verify({			
				  username: function(value, item){ //value：表单的值、item：表单的DOM对象
				    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
				      return '用户名不能有特殊字符';
				    }
				    if(/(^\_)|(\__)|(\_+$)/.test(value)){
				      return '用户名首尾不能出现下划线\'_\'';
				    }
				    if(/^\d+\d+\d$/.test(value)){
				      return '用户名不能全为数字';
				    }
				  }	  
				  //我们既支持上述函数式的方式，也支持下述数组的形式
				  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
				  ,userpasswd: [
				    /^[\S]{6,12}$/
				    ,'密码必须6到12位，且不能出现空格'
				  ] 
				});
			
		});
		
		     
	</script>
	<script>
		var handler1 = function(captchaObj) {
			$("#submit1").click(function(e) {
				var result = captchaObj.getValidate();
				if (!result) {
					$("#notice1").css("display", "block");
					setTimeout(function() {
						$("#notice1").hide();
					}, 2000);
					e.preventDefault();
				}
			});
			// 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
			captchaObj.appendTo("#captcha1");
			captchaObj.onReady(function() {
				$("#wait1").hide();
			});
			// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
		};
		$.ajax({
			url : "gt/register1?t=" + (new Date()).getTime(), // 加随机数防止缓存
			type : "get",
			dataType : "json",
			success : function(data) {
				// 调用 initGeetest 初始化参数
				// 参数1：配置参数
				// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
				initGeetest({
					gt : data.gt,
					challenge : data.challenge,
					new_captcha : data.new_captcha, // 用于宕机时表示是新验证码的宕机
					offline : !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
					product : "float", // 产品形式，包括：float，popup
					width : "100%"
				// 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
				}, handler1);
			}
		});
		function userLogin(){
			 window.location.href="login";
			}
	</script>

</body>
</html>