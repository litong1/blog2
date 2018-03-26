<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<title>首页</title>
</head>
<body>
 this is shouye
 <p ><font color="red">${user.userid}</font></p>
 <button class="layui-btn layui-btn-lg layui-btn-warm" id="register" type="button" onclick="userRegister()" >写文章</button>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="layui/layui.js"></script>
<script type="text/javascript">
function userRegister(){
	 window.location.href="postedit";
	}
</script>
</body>
</html>