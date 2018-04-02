$(document).ready(function(){
	var uid = $("#userid").val();
	$.ajax({
		url:"articleCategoryList",
		method:"get",
		async: true,
		data:{
			_method : "get",
			userid:uid
			},
		dataType : "json",
   		
		success : function(data) {						
				 $.each(data, function(i, item) {
					 var input = "<input type='checkbox' name='divclist' lay-skin='primary' lay-filter='cname' title="+item.categoryname+" value="+item.categoryname+">";
						$("#catlist").append(input);
				 });		
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
		}
	});
}); 
$(function() {
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		
		layui.use('layer', function(){
			  var layer = layui.layer;
			}); 
		var uid = $("#userid").val();
		
		
		layui.use('form', function(){
			  var form = layui.form;	
			  form.on('switch(isPrivate)', function(data){
					 if(data.elem.checked==true){
						 data.elem.value=1;
						 //console.log(data.elem.value);
					 }else{
						 data.elem.value=0;
						 //console.log(data.elem.value);
					 }
				 });
			  form.on('checkbox(cname)', function(data){
				  if(data.elem.checked==true){
					  var input = "<div class='layui-input-inline'><input type='text' name='catlist' class='layui-input' value="+data.value+">"
							 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
							 +"<i class='layui-icon'>&#xe640;</i></button></div>";
							$("#addCat").before(input);
				  }else{
					  $("input[name='catlist']").each(function(key,value){							
							if($("input[name='catlist']")[key].value==data.value){
								console.log($("input[name='catlist']")[key]);
								$("input[name='catlist']")[key].parentNode.remove();
							}
						});
				  }
				  //console.log(data.elem); //得到checkbox原始DOM对象
				  //console.log(data.elem.checked); //是否被选中，true或者false
				  //console.log(data.value); //复选框value值，也可以通过data.elem.value得到
				  //console.log(data.othis); //得到美化后的DOM对象
				});  
			  $("#addCat").click(function(){
					var val = $("#addCat").prev().find("input[name='catlist']").val();
					if(val!=""){
						$("input[name='divclist']").each(function(key,value){
							
							if($("input[name='divclist']")[key].value==val){
								console.log($("input[name='divclist']")[key]);
								$("input[name='divclist']")[key].checked=true;
								form.render();
							}
						});
						var input = "<div class='layui-input-inline'><input type='text' name='catlist' class='layui-input'>"
							 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteCat' type='button'>"
							 +"<i class='layui-icon'>&#xe640;</i></button></div>";
							$("#addCat").before(input);
					}else{
						layer.msg('分类名不能为空！0.0');
					}		
				});
			  $(".itemCat").on('click',"button[name='deleteCat']",function(){
					var val = $("#addCat").prev().find("input[name='catlist']").val();
					$("input[name='divclist']").each(function(key,value){
						
						if($("input[name='divclist']")[key].value==val){
							console.log($("input[name='divclist']")[key]);
							$("input[name='divclist']")[key].checked=false;
							form.render();
						}
					});
					 $(this).parent().remove();
					 
				});	
			});
		
		//发布博客
		$("#pblog").click(function(){
			console.log("uid"+uid);
			var atype = $("select[name='type']").val();
			console.log(atype);
			var atitle = $("input[name='articletitle']").val();
			console.log(atitle);
			var atags = new Array();							
			$("input[name='arlabel']").each(function(key,value){						
				atags[key]=$(this).val();
			});
			console.log(atags);
			var acats = new Array();
			$("input[name='catlist']").each(function(key,value){						
				acats[key]=$(this).val();
			});
			console.log(acats);
			var bcat = $("select[name='bcat']").val();
			console.log(bcat);
			var apre = $("input[name='switch']").val();
			console.log(apre);
			
			var content = CKEDITOR.instances.content.getData();
			console.log(content);
			$.ajax({
				url:"addArticle",
				method:"post",
				async: true,
				data:{
					article_userid:uid,
					articletype:atype,
					articletitle:atitle,
					article_tag:atags.toString(),
					article_personcategoty:acats.toString(),
					article_blogcategory:bcat,
					article_isPrivate:apre,
					articlestate:1,
					articlecontent:content,
					traditional:true,    //这里必须设置
					},
				dataType : "json",
		   		
				success : function(data) {						
					window.location.href="articleAddesult";
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
		            alert(XMLHttpRequest.readyState);
		            alert(XMLHttpRequest.responseText);
				}
			});
		});
		$("#postedit").click(function(){
			window.location.href="postedit";
		});
		$(".itemLabel").on('click',"button[name='deleteLabel']",function(){
			 $(this).parent().remove();
			 
		});	
		$("#addLabel").click(function(){
			var val = $("#addLabel").prev().find("input[name='arlabel']").val();
			if(val!=""){
				var input = "<div class='layui-input-inline'><input type='text' name='arlabel' class='layui-input'>"
					 +"<button class='layui-btn layui-btn-sm layui-bg-blue' name='deleteLabel' type='button'>"
					 +"<i class='layui-icon'>&#xe640;</i></button></div>";
					 var divNum = $("button[name='deleteLabel']").length;
					 if(divNum <5){
						$("#addLabel").before(input);
					 }else{
						 layer.alert("最多添加五个标签");
					 }
			}else{
				layer.msg('标签名不能为空！0.0');
			}
			
			
		});
});