<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			*{margin: 0; padding: 0;}
			table{border-collapse:collapse;}
			table tbody tr td{border:1px solid #666;}
			.backgroundShadow{display:none;width:100%;height:100%;position:absolute;z-index:1;top:0;}
			.backgroundShadow form.addBox{width:300px;height:400px;background:#999;margin:100px auto;}
		</style>
		<base href="${basePath}">
	</head>
	<body>
		<header>
			<div class="mainText">教师管理</div>
			<a id="selectTeacher" href="teacherServlet?method=GET" >查询所有</a>
			<a id="addTeacher" href="javascript:;">添加教师</a>
			<c:if test="${result != null}">
				<c:if test="${result == 1}">
					操作成功
				</c:if>
				<c:if test="${result != 1}">
					操作失败
				</c:if>
			</c:if>
			<form method="POST" action="teacherServlet">
				<input type="hidden" name="method" value="GET"/>
				<input type="text" name="searchId" id="searchId" placeholder="教师id"/>
				<input type="submit" value="搜索"/>
			</form>
		</header>
		<table>
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>年龄</td>
					<td>地址</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="allTeacher">
				<c:forEach items="${teacherList}" var="teacher">
					<tr>
						<td>${teacher.teacherId}</td>
						<td>${teacher.teacherName}</td>
						<td>${teacher.teacherAge}</td>
						<td>${teacher.teacherAddress}</td>
						<td>
							<a class="updateTeacher" href="javascript:;" data-id="${teacher.teacherId}">修改</a>
							<a href="teacherServlet?method=DELETE&teacherId=${teacher.teacherId}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="backgroundShadow" id="backgroundShadow">
			<form method="POST" action="teacherServlet" class="addBox" id="myForm">
				<span>教师姓名：</span><input type="text" name="teacherName" id="teacherName"/><br/>
				<span>教师年龄：</span><input type="text" name="teacherAge" id="teacherAge"/><br/>
				<span>教师地址：</span><input type="text" name="teacherAddress" id="teacherAddress"/><br/>
				<input style="display:none" id="submit" type="submit" value="提交">
				<a id="addBtn" href="javascript:;">添加</a>
				<a id="updateBtn" href="javascript:;" style="display:none">修改</a>
			</form>
		</div>
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			(function(){
				//弹出添加框
				$("#addTeacher").click(function(){
					$("#backgroundShadow").show();
					$("#myForm").append("<input type='hidden' name='method' value='POST'>");
				});
				//添加事件
				$("#addBtn").click(function(){
					var teacherName = $.trim($("#teacherName").val());
					var teacherAge = $.trim($("#teacherAge").val());
					var teacherAddress = $.trim($("#teacherAddress").val());
					if(teacherName == "" || teacherName == null || teacherAge == "" || teacherAge == null || teacherAddress == "" || teacherAddress == null){
						alert("请完善信息再提交");
					}else{
						$("#teacherName").val(teacherName);
						$("#teacherAge").val(teacherAge);
						$("#teacherAddress").val(teacherAddress);
						$("#submit").trigger("click");
					}
				});
				//弹出更新框
				$(".updateTeacher").on("click",function(){
					var $trDom = $(this).parent().parent();
					var teacherName = $trDom.children().eq(1).text();
					var teacherAge = $trDom.children().eq(2).text();
					var teacherAddress = $trDom.children().eq(3).text();
					$("#teacherName").val(teacherName);
					$("#teacherAge").val(teacherAge);
					$("#teacherAddress").val(teacherAddress);
					$("#backgroundShadow").show();
					$("#myForm").append("<input type='hidden' name='method' value='PUT'><input style='display:none' type='text' name='teacherId' id='teacherId' value='"+$(this).data("id")+"'/>");
					$("#addBtn").hide();
					$("#updateBtn").show();
				});
				//修改事件
				$("#updateBtn").click(function(){
					var teacherId = $("#teacherId").val();
					var teacherName = $.trim($("#teacherName").val());
					var teacherAge = $.trim($("#teacherAge").val());
					var teacherAddress = $.trim($("#teacherAddress").val());
					if(teacherId == "" || teacherId == null || teacherName == "" || teacherName == null || teacherAge == "" || teacherAge == null || teacherAddress == "" || teacherAddress == null){
						alert("请完善信息再提交");
					}else{
						$("#teacherName").val(teacherName);
						$("#teacherAge").val(teacherAge);
						$("#teacherAddress").val(teacherAddress);
						$("#submit").trigger("click");
					}
				});
			})();
		</script>
	</body>
</html>